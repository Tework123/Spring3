package com.spring3.spring3.entities;


import com.spring3.spring3.entities.enums.Brand;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
//    @Column(name="role")
    private Brand brand;

    @ManyToMany
    private Set<User> users;

    private int power;
}
