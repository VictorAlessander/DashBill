package com.app.dashbill.service;


import com.app.dashbill.entity.Person;
import com.app.dashbill.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

    private PersonRepository personRepo;

    public PersonService(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }


    public boolean createPerson(Person person) {
        personRepo.save(person);
        
        return true;
    }

    public List<Person> listPeople() {
        return personRepo.findAll();
    }

    public void deletePerson(String id) {
        personRepo.deleteById(id);
    }

    public Optional<Person> getPersonById(String id) {
        Optional<Person> query = personRepo.findById(id);

        return query;
    }
}
