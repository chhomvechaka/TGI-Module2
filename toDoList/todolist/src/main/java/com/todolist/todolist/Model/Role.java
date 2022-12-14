package com.todolist.todolist.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import static javax.persistence.FetchType.LAZY;
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long roleId;
    private String name;
    private String description;
    @ManyToMany(fetch = LAZY)
    private Set<Privilege> privileges = new HashSet<>(0);
    public Long getRoleId() {
      return roleId;
    }
    public void setRoleId(Long roleId) {
      this.roleId = roleId;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getDescription() {
      return description;
    }
    public void setDescription(String description) {
      this.description = description;
    }
    public Set<Privilege> getPrivileges() {
      return privileges;
    }
    public void setPrivileges(Set<Privilege> privileges) {
      this.privileges = privileges;
    }
    public Role(Long roleId, String name, String description, Set<Privilege> privileges) {
      this.roleId = roleId;
      this.name = name;
      this.description = description;
      this.privileges = privileges;
    }
    public Role(){}
}
