package com.spring3.spring3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarController {

    @GetMapping("/cars")
    public String getCars() {
        return "car/getCarsTemplate";

    }
}
