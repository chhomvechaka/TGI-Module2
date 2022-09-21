package com.todolist.todolist.Model;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter

public class UserAccount {
  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  private String username;
  private String password;
  private String facebookname;
  @ManyToMany(fetch = FetchType.LAZY)
  private Set<Role> roles;
  private String status;
  private boolean enabled = true;
  public UserAccount(Long id, String username, String password, Set<Role> roles, String status, boolean enabled) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.roles = roles;
    this.status = status;
    this.enabled = enabled;
  }
  public UserAccount() {

  }

}
