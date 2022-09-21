package com.todolist.todolist.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.todolist.todolist.Model.Role;
public interface Rolerepository extends JpaRepository<Role,Long>{
    Optional<Role> findByName(String name);
}
