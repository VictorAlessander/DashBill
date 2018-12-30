package com.app.dashbill.service;


import com.app.dashbill.entity.Person;
import com.app.dashbill.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;


    public boolean createPerson(Person person) {
        personRepo.save(person);
        
        return true;
    }

    public List<Person> listPeople() {
        return personRepo.findAll();
    }

    public boolean deletePerson(String id) {
        Optional<Person> query = personRepo.findById(id);

        if (query.isPresent()) {
            personRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public Optional<Person> getPersonById(String id) {
        Optional<Person> query = personRepo.findById(id);

        return query;
    }
}
