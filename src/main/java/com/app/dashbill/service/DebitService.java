package com.app.dashbill.service;


import java.time.LocalDate;
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
    
    public Debit getDebit(long id) {
    	Optional<Debit> query = debitRepo.findById(id);
    	
    	return query.isPresent() ? query.get() : null;
    }
    
    public void removeDebit(long id) {
    	debitRepo.deleteById(id);
    }
    
    public List<Debit> getDebitsByDateRange(LocalDate fromDate, LocalDate toDate) {
    	return debitRepo.getDebitsByDateRange(fromDate, toDate);
    	
    }
}
