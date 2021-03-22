package com.ashishcoder.demo.service;

import com.ashishcoder.demo.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person findById(int theId);

}

