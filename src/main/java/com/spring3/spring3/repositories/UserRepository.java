package com.spring3.spring3.repositories;

import com.spring3.spring3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAll();

    public User findByEmail(String email);
}
