package com.spring3.spring3.controllers;

import com.spring3.spring3.entities.Person;
import com.spring3.spring3.services.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PeopleController {
    private final PersonService personService;

//    public PeopleController(PersonService personService) {
//        this.personService = personService;
//    }

    @GetMapping("/people")
    public String getPeoples(Model model) {
        model.addAttribute("people", personService.listPeople());
        return "people/getPeoplesTemplate";
    }


    @GetMapping("/people/{id}")
    public String getPerson(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("person", personService.getPerson(id));
        return "people/getPersonTemplate";
    }

    @GetMapping("/people/create")
    public String getCreatePersonTemplate(@ModelAttribute("person") Person person) {
        return "people/createPersonTemplate";
    }

    @PostMapping("/people")
    public String createPerson(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/createPersonTemplate";
        }
        personService.createPerson(person);
        return "redirect:/people";

    }

    @GetMapping("/people/{id}/edit")
    public String getEditPersonTemplate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("person", personService.getPerson(id));
        return "people/editPersonTemplate";
    }

    @PatchMapping("/people/{id}")
    public String editPerson(@ModelAttribute("person") @Valid Person person,
                             BindingResult bindingResult,
                             @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "people/editPersonTemplate";
        }
        personService.editPerson(person);
        return "redirect:/people";
    }

    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
        return "redirect:/people";
    }


}

