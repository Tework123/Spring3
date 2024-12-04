package com.spring3.spring3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleController {

    @GetMapping("/peoples")
    public String getPeoplesController() {
        return "people/getPeoplesTemplate";

    }
}
