package com.app.dashbill.controller;


import com.app.dashbill.entity.Person;
import com.app.dashbill.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/person/new", method = RequestMethod.POST)
    public ResponseEntity<String> newPerson(@Valid @RequestBody Person person) {
        boolean result = personService.createPerson(person);

        if (!result) {
            return new ResponseEntity<>("BAD REQUEST", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public ResponseEntity<?> getPeople() {

        List<Person> result = personService.listPeople();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/person/remove/{idPerson}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@PathVariable String idPerson) {
        boolean result = personService.deletePerson(idPerson);

        if(!result) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/person/{idPerson}", method = RequestMethod.GET)
    public ResponseEntity<?> getPerson(@PathVariable String idPerson) {
        Optional<Person> result = personService.getPersonById(idPerson);

        if (!result.isPresent()) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
