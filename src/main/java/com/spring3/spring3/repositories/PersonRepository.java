package com.spring3.spring3.repositories;

import com.spring3.spring3.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    public List<Person> findAll();
}
