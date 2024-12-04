package com.spring3.spring3.dao;

import com.spring3.spring3.models.Person;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(1, "Dima"));
        people.add(new Person(2, "Dima2"));
        people.add(new Person(3, "Dima3"));
    }

    public List<Person> getPeoples() {
        return people;
    }

    public Person getPerson(int id) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id) {
                return people.get(i);
            }
        }
        return null;
    }

    public void savePerson(Person person) {
        person.setId(228);
        people.add(person);
    }

    public void editPerson(int id, Person person) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id) {
                people.get(i).setName(person.getName());
            }
        }
    }

    public void deletePerson(int id) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id) {
                people.remove(i);
            }
        }
    }
}
