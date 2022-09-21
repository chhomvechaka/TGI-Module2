package com.todolist.todolist.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Done {
    @Id
    @GeneratedValue
    private int workID;
    private String work;
    
}
