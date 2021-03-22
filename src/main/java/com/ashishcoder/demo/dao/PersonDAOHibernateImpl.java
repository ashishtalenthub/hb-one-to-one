package com.ashishcoder.demo.dao;

import com.ashishcoder.demo.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonDAOHibernateImpl implements PersonDAO {

    // define field for entity manager
    private final EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public PersonDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create  a query
        Query<Person> theQuery =
                currentSession.createQuery("from Person", Person.class);

        // execute query and get result list
        List<Person> persons = theQuery.getResultList();
        currentSession.close();

        // return the persons
        return persons;
    }

    @Override
    public Person findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // execute query and get result list
        Person thePerson = currentSession.get(Person.class, theId);

        currentSession.close();

        // return the single person
        return thePerson;
    }
}
