package com.ashishcoder.demo.rest;


import com.ashishcoder.demo.entity.Person;
import com.ashishcoder.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    private final PersonService personService;

    // set up constructor injection

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> findAll() {
        return personService.findAll();
    }


    @GetMapping("/persons/{personId}")
    public Person getPerson(@PathVariable int personId) {
        Person thePerson = personService.findById(personId);
        return thePerson;

    }

}

