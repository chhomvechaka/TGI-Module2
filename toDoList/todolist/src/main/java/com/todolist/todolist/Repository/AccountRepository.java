package com.todolist.todolist.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.todolist.Model.UserAccount;

public interface AccountRepository extends JpaRepository<UserAccount,Long> {
  Optional<UserAccount> findByUsername(String username);
}
