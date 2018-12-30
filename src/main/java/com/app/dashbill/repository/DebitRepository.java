package com.app.dashbill.repository;


import java.util.Date;
import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.dashbill.entity.Debit;

public interface DebitRepository extends MongoRepository<Debit, String> {

	List<Debit> findByDateBetween(Date fromDate, Date toDate);
}
