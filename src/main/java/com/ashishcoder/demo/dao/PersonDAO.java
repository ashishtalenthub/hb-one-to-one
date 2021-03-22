package com.ashishcoder.demo.dao;


import com.ashishcoder.demo.entity.Person;

import java.util.List;

public interface PersonDAO {

    List<Person> findAll();

    Person findById(int theId);

}

