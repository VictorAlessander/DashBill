package com.app.dashbill.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.dashbill.entity.Debit;
import com.app.dashbill.service.DebitService;


@Controller
public class DebitController {

    private DebitService debitService;

    public DebitController(DebitService debitService) {
        this.debitService = debitService;
    }

    @RequestMapping(value = "/debit/new", method = RequestMethod.POST)
    public ResponseEntity<String> newDebit(@RequestBody Resource<Debit> debitResource) {
        Debit debit = debitResource.getContent();
        debitService.createDebit(debit);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/debit", method = RequestMethod.GET)
    public ResponseEntity<?> getDebits() {
    	List<Debit> debits = debitService.listDebits();
    	
    	if (debits.isEmpty()) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	
    	return new ResponseEntity<>(debits, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/debit/{debitId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDebit(@PathVariable("debitId") String debitId) {
    	Debit debit = debitService.getDebit(debitId);
    	
    	if (debit == null) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	
    	return new ResponseEntity<>(debit, HttpStatus.OK);
    	
    }
    
    @RequestMapping(value = "/debit/remove/{debitId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeDebit(@PathVariable String debitId) {
    	debitService.removeDebit(debitId);
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/debit/{fromDate}/{toDate}", method = RequestMethod.GET)
    public ResponseEntity<?> getDebitByDateRange(
    		@PathVariable("fromDate") @DateTimeFormat(iso=ISO.DATE) Date fromDate,
    		@PathVariable("toDate") @DateTimeFormat(iso=ISO.DATE) Date toDate) {
    	List<Debit> debits = debitService.getDebitsByDateRange(fromDate, toDate);
    	
    	return debits.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(debits, HttpStatus.OK);
    }
}
