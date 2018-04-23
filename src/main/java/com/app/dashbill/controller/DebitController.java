package com.app.dashbill.controller;


import com.app.dashbill.entity.Debit;
import com.app.dashbill.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class DebitController {

    @Autowired
    DebitService debitService;

    @RequestMapping(value = "/dashbill/new", method = RequestMethod.POST)
    public ResponseEntity<String> newDebit(@RequestBody Debit debit) {
        boolean result = debitService.createDebit(debit);

        if (!result) {
            return new ResponseEntity<>("BAD REQUEST", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/dashbill", method = RequestMethod.GET)
    public List<Debit> getDebits() {
        return debitService.listDebits();
    }
}
