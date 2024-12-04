package com.spring3.spring3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PeopleController {

    @GetMapping("/peoples")
    public String getPeoples(Model model, @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("sex", name);
        System.out.println(name);
        return "people/getPeoplesTemplate";

    }
}

