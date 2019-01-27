package com.app.dashbill.seeders;


import com.app.dashbill.entity.Debit;
import com.app.dashbill.entity.Person;
import com.app.dashbill.enums.CategoryEnum;
import com.app.dashbill.repository.DebitRepository;
import com.app.dashbill.repository.PersonRepository;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;


@Component
public class DatabaseSeeder {

    private DebitRepository debitRepository;
    private PersonRepository personRepository;
    private Faker faker = new Faker();
    private Logger logger = LogManager.getLogger(DatabaseSeeder.class);

    public DatabaseSeeder(
            DebitRepository debitRepository, PersonRepository personRepository) {
        this.debitRepository = debitRepository;
        this.personRepository = personRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedPersonTable();
        seedDebitTable();
    }

    private void seedDebitTable() {

        List<Debit> debits = debitRepository.findAll();

        if (debits.isEmpty()) {
            Debit d1 = new Debit();
            d1.setCategory(CategoryEnum.BIRTHDAY);
            d1.setBalance(BigInteger.valueOf(400L));
            d1.setDate(faker.date().birthday());
            d1.setPerson(personRepository.findAll().get(1));
            debitRepository.save(d1);
            logger.info("Debits saved");
        }
        else {
            logger.trace("Debit seeding not required");
        }
    }

    private void seedPersonTable() {

        List<Person> people = personRepository.findAll();

        if (people.isEmpty()) {
            Person p1 = new Person();
            p1.setName(faker.name().name());
            personRepository.save(p1);

            Person p2 = new Person();
            p2.setName(faker.name().name());
            personRepository.save(p2);

            logger.info("People saved");
        }
        else {
            logger.trace("Person seeding not required");
        }
    }
}
