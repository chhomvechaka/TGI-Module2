package com.todolist.todolist.ModelDto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserAccountDTO {
  private String username;
  private String password;
  public UserAccountDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }
  public UserAccountDTO(){}
}
