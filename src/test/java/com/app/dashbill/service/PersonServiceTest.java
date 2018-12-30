package com.app.dashbill.service;


import com.app.dashbill.DashBillApplicationTest;
import com.app.dashbill.entity.Person;
import com.app.dashbill.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = DashBillApplicationTest.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void whenPersonToGetNotExists() {
        Optional<Person> query = personService.getPersonById("1");

        Assert.assertEquals(Optional.empty(), query);
    }

    @Test
    public void whenPersonToGetExists() {
        Person p = new Person();
        p.setId("1");
        p.setName("Alessander");
        personRepository.save(p);

        Optional<Person> res = personService.getPersonById("2");

        Assert.assertNotEquals(Optional.empty(), res.get());
    }

    @Test
    public void whenPersonToDeleteNotExists() {
        boolean query = personService.deletePerson("1");

        Assert.assertFalse(query);
    }

    @Test
    public void whenPersonToDeleteExists() {
        Person p = new Person();
        p.setId("1");
        p.setName("Alessander");
        personRepository.save(p);

        boolean query = personService.deletePerson("1");

        Assert.assertTrue(query);
    }
}
