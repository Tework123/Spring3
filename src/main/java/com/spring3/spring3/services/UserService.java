package com.spring3.spring3.services;


import com.spring3.spring3.entities.User;
import com.spring3.spring3.entities.enums.Role;
import com.spring3.spring3.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public List<User> listPeople() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exist");
        }
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        userRepository.save(user);
        return true;
    }

    public void editUser(User user) {
        User oldUser = userRepository.findById((int) user.getId()).orElse(null);
        oldUser.setUsername(user.getUsername());
        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
