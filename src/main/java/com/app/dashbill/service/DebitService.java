package com.app.dashbill.service;


import com.app.dashbill.entity.Debit;
import com.app.dashbill.repository.DebitRepository;
import com.app.dashbill.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DebitService {

    @Autowired
    DebitRepository debitRepo;

    public boolean createDebit(Debit debit) {
        if (!Validator.isNullOrEmpty(debit)) {
            debitRepo.save(debit);

            return true;
        }

        return false;
    }

    public List<Debit> listDebits() {
        return debitRepo.findAll();
    }
}
