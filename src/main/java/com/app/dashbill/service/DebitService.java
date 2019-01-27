package com.app.dashbill.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dashbill.entity.Debit;
import com.app.dashbill.repository.DebitRepository;


@Service
public class DebitService {

    @Autowired
    private DebitRepository debitRepo;

    public void createDebit(Debit debit) {
        debitRepo.save(debit);
    }

    public List<Debit> listDebits() {
        return debitRepo.findAll();
    }
    
    public Debit getDebit(String id) {
    	Optional<Debit> query = debitRepo.findById(id);
    	
    	return query.orElse(null);
    }
    
    public void removeDebit(String id) {
    	debitRepo.deleteById(id);
    }
    
    public List<Debit> getDebitsByDateRange(Date fromDate, Date toDate) {
    	return debitRepo.findByDateBetween(fromDate, toDate);
    	
    }
}
