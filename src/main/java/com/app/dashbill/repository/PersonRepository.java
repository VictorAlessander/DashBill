package com.app.dashbill.repository;


import com.app.dashbill.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> { }
