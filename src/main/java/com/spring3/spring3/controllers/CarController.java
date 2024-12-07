package com.spring3.spring3.controllers;

import com.spring3.spring3.entities.Car;
import com.spring3.spring3.entities.User;
import com.spring3.spring3.services.CarService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


@Controller
public class CarController {
    CarService carService;

    @GetMapping("/cars/create")
    public String getCreateCarTemplate(Car car) {
        return "car/createCarTemplate";
    }


    @PostMapping("/cars")
    public String createCar(@AuthenticationPrincipal User currentUser, @Valid Car car) {
        System.out.println(currentUser.getId());
        carService.c
        return "car/createCarTemplate";
    }

    @GetMapping("/cars")
    public String getCars() {
        return "car/getCarsTemplate";

    }
}
