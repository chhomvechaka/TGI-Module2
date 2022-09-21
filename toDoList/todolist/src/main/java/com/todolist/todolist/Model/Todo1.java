package com.todolist.todolist.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class Todo1 {
    @Id
    @GeneratedValue
    private int workID;
    private String work;
}
