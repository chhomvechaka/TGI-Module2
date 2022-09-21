package com.todolist.todolist.Implement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.todolist.todolist.BaseService.BaseServiceimp;
import com.todolist.todolist.Model.Role;
import com.todolist.todolist.Model.UserAccount;
import com.todolist.todolist.ModelDto.UserAccountDTO;
import com.todolist.todolist.Repository.AccountRepository;
import com.todolist.todolist.Repository.Rolerepository;
import com.todolist.todolist.service.AccountService;
import java.util.*;
@Service
public class UserAccountServiceimp extends BaseServiceimp<UserAccount,List<UserAccount>,Long,UserAccountDTO> implements AccountService {
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private Rolerepository rolerepository;
  private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
  @Override
  protected JpaRepository<UserAccount,Long> getrepository() {
    return accountRepository;
  }
  @Override
  public List<UserAccount> getalldata() {
    return accountRepository.findAll();
  }
  @Override
  public UserAccount Create(UserAccountDTO model) {
    long num=accountRepository.count();
    Role roles = rolerepository.findByName("ROLE_USER").get();
    Set<Role> role= new HashSet<>();
    role.add(roles);
    UserAccount account=new UserAccount();
    account.setId((long)(num+1));
    account.setEnabled(true);
    account.setUsername(passwordEncoder.encode(model.getUsername()));
    account.setPassword(passwordEncoder.encode(model.getPassword()));
    account.setRoles(role);
    account.setStatus("Active");
    return accountRepository.save(account);
  }
  @Override
  public String Update(Long id, UserAccountDTO model) {
    UserAccount account= accountRepository.findById(id).get();
    account.setUsername(passwordEncoder.encode(model.getUsername()));
    account.setPassword(passwordEncoder.encode(model.getPassword()));
    accountRepository.save(account);
    return "Update Success";
  }
  @Override
  public UserAccount Delete(Long id, UserAccountDTO model) {

    return null;
  }
}
