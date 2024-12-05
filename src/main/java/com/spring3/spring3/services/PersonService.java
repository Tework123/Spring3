package com.spring3.spring3.services;


import com.spring3.spring3.entities.Person;
import com.spring3.spring3.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }

    public List<Person> listPeople() {
        return personRepository.findAll();
    }

    public Person getPerson(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public void editPerson(Person person) {
        Person oldPerson = personRepository.findById(person.getId()).orElse(null);
        oldPerson.setName(person.getName());
        personRepository.save(oldPerson);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
