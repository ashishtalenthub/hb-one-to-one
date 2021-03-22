package com.ashishcoder.demo.service;

import com.ashishcoder.demo.dao.PersonDAO;
import com.ashishcoder.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    // set up constructor injection
    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @Override
    @Transactional
    public Person findById(int theId) {
        return personDAO.findById(theId);
    }
}
