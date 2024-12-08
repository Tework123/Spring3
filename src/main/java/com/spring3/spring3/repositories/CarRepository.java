package com.spring3.spring3.repositories;

import com.spring3.spring3.entities.Car;
import com.spring3.spring3.entities.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    public List<Car> findAll();

    public Car findByUsers(User currentUser);
}
