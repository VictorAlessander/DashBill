package com.app.dashbill;

import com.app.dashbill.service.DebitService;
import com.app.dashbill.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {
        PersonService.class,
        DebitService.class
})
@SpringBootApplication
public class DashBillApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(DashBillApplicationTest.class, args);
    }
}
