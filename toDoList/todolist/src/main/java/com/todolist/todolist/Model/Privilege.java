package com.todolist.todolist.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Privilege {
    @Id
    @GeneratedValue
    private long privilegeId;
    private String name;
    private String description;
    public long getPrivilegeId() {
      return privilegeId;
    }
    public void setPrivilegeId(long privilegeId) {
      this.privilegeId = privilegeId;
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

    public Privilege(long privilegeId, String name, String description) {
      this.privilegeId = privilegeId;
      this.name = name;
      this.description = description;
    }
    public Privilege(){}
}
