package com.todolist.todolist.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todolist.todolist.Model.UserAccount;
import com.todolist.todolist.ModelDto.UserAccountDTO;
import com.todolist.todolist.service.AccountService;
@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
  @Autowired
  private AccountService accountService;
  @GetMapping
  @PreAuthorize("hasAuthority('PRIVILEGE_USER_READ')")
  public ResponseEntity<List<UserAccount>> getfile(){
    return new ResponseEntity<>(accountService.getalldata(),HttpStatus.OK);
  }
  @PostMapping("/new")
  public ResponseEntity<UserAccount> create(@RequestBody UserAccountDTO dto){
    return new ResponseEntity<>(accountService.Create(dto),HttpStatus.OK);
  }
  @PostMapping("/User/Update")
  @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_UPDATE')")
  public ResponseEntity<String> Userupdare(long id,@RequestBody UserAccountDTO dto){
    return new ResponseEntity<>(accountService.Update(id, dto),HttpStatus.OK);
  }
}
