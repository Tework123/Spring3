package com.spring3.spring3.entities;


import com.spring3.spring3.entities.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Size(min = 3, max = 30, message = "3 to 30")
    private String username;

    @Column(unique = true)
    @Size(min = 3, max = 30, message = "3 to 30")
    private String email;

    @Column(length = 1000)
    @Size(min = 4, max = 1000, message = "min 4")
    private String password;

    //    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
//    @Column(name="role")
    private Role role;

    @ManyToMany
    private Set<Car> cars;

    private boolean active;

    private LocalDate dateJoined;

}
