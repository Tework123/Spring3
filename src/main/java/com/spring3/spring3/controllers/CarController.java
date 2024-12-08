package com.spring3.spring3.controllers;

import com.spring3.spring3.entities.Car;
import com.spring3.spring3.entities.User;
import com.spring3.spring3.services.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/cars/create")
    public String getCreateCarTemplate(Car car) {
        return "car/createCarTemplate";
    }


    @PostMapping("/cars")
    public String createCar(@Valid Car car, @AuthenticationPrincipal User currentUser) {
        System.out.println(currentUser.getId());
        carService.createCar(car, currentUser);
        return "redirect:/users";
    }


    @GetMapping("/cars")
    public String getCars(Model model) {
        model.addAttribute("cars", carService.listCars());
        return "car/getCarsTemplate";
    }


    @GetMapping("/cars/{id}")
    public String getCar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("car", carService.getCar(id));

        return "car/getCarTemplate";
    }
}
