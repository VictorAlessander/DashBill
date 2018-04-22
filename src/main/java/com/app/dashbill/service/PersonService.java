package com.app.dashbill.service;


import com.app.dashbill.entity.Person;
import com.app.dashbill.repository.PersonRepository;
import com.app.dashbill.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;


    public boolean createPerson(Person person) {
        if (!Validator.isNullOrEmpty(person)) {
            personRepo.save(person);

            return true;
        }

        return false;
    }
}
