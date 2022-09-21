package com.todolist.todolist.Security;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.todolist.Model.Privilege;
import com.todolist.todolist.Model.Role;
import com.todolist.todolist.Model.UserAccount;
import com.todolist.todolist.Repository.AccountRepository;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService{
  private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
  private final AccountRepository accountRepository;
  public CustomUserDetailsService(AccountRepository accountRepository){
    this.accountRepository=accountRepository;
  }
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<UserAccount> list=new ArrayList<>();
    list=accountRepository.findAll();
    for (UserAccount userAccount : list) {
        if(passwordEncoder.matches(username, userAccount.getUsername())==true){
          username=userAccount.getUsername();
        }
    }
    Optional<UserAccount> accountbyusername=accountRepository.findByUsername(username);
    if(!accountbyusername.isPresent()){
      throw new UsernameNotFoundException("User"+ username+ "not found.");
    }
    UserAccount account=accountbyusername.get();
    if(account.getRoles()==null || account.getRoles().isEmpty()){
      throw new UsernameNotFoundException("User not Authorize.");
    }
    return new User(account.getUsername(), account.getPassword(), account.isEnabled(), true, true, true, getAuthorities(account.getRoles()));
  }
  private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
    return getGrantedAuthorities(getPrivileges(roles));

}
private List<String> getPrivileges(Collection<Role> roles) {
  List<Privilege> privileges = roles.stream()
          .map(Role::getPrivileges)
          .flatMap(Set::stream)
          .collect(toList());
  return privileges.stream()
          .map(Privilege::getName)
          .collect(toList());
}

private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
  return privileges.stream()
          .map(SimpleGrantedAuthority::new)
          .collect(toList());
}
}
