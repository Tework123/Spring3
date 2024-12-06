package com.spring3.spring3.services;


import com.spring3.spring3.entities.User;
import com.spring3.spring3.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> listPeople() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void createUser(User user) {
        userRepository.save(user);
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
