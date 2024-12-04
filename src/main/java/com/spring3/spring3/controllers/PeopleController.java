package com.spring3.spring3.controllers;

import com.spring3.spring3.dao.PersonDAO;
import com.spring3.spring3.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PeopleController {
    private PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/people")
    public String getPeoples(Model model) {
        model.addAttribute("people", personDAO.getPeoples());
        return "people/getPeoplesTemplate";
    }


    @GetMapping("/people/{id}")
    public String getPerson(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "people/getPersonTemplate";
    }

    @GetMapping("/people/create")
    public String getCreatePersonTemplate(@ModelAttribute("person") Person person) {
        return "people/createPersonTemplate";

    }

    @PostMapping("/people")
    public String createPerson(@ModelAttribute("person") Person person) {
        personDAO.savePerson(person);
        return "redirect:/people";

    }

    @GetMapping("/people/{id}/edit")
    public String getEditPersonTemplate(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "people/editPersonTemplate";
    }

    @PatchMapping("/people/{id}")
    public String editPerson(@ModelAttribute("person") Person person,
                             @PathVariable("id") int id) {
        personDAO.editPerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personDAO.deletePerson(id);
        return "redirect:/people";
    }


}

