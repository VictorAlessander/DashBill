package com.app.dashbill.controller;


import com.app.dashbill.service.DebitService;
import com.app.dashbill.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DashBillController {

    @Autowired
    PersonService personService;

    @Autowired
    DebitService debitService;
}
