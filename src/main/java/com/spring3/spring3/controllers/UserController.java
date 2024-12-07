package com.spring3.spring3.controllers;

import com.spring3.spring3.entities.User;
import com.spring3.spring3.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "people/loginTemplate";
    }

    @GetMapping("/registration")
    public String register(User user) {
        return "people/registerTemplate";
    }

    @PostMapping("/registration")
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/registerTemplate";
        }
        userService.createUser(user);
        return "redirect:/users";

    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.listPeople());
        return "people/getPeoplesTemplate";
    }


    @GetMapping("/users/{id}")
    public String getUser(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUser(id));
        return "people/getPersonTemplate";
    }


    @GetMapping("/users/{id}/edit")
    public String getEditUserTemplate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUser(id));
        return "people/editPersonTemplate";
    }

    @PatchMapping("/users/{id}")
    public String editUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult,
                           @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "people/editPersonTemplate";
        }
        userService.editUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}

