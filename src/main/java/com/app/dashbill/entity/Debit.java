package com.app.dashbill.entity;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


import javax.validation.constraints.NotNull;

import com.app.dashbill.enums.CategoryEnum;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "debits")
@Data
@NoArgsConstructor
public class Debit implements Serializable {

    @Id
    private String id;

    @NotNull
    private BigInteger balance;
    
    @NotNull
    private Date date;
    
    @NotNull
    private CategoryEnum category;

    @DBRef
    private Person person;
}
