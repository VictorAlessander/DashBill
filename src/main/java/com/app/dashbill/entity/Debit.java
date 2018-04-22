package com.app.dashbill.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigInteger;
import java.util.Date;

@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
public class Debit {

    @Id
    @GeneratedValue
    private long id;
    private BigInteger balance;
    private Date date;

    @OneToOne(mappedBy = "debit", cascade = CascadeType.ALL) @NonNull
    private Person person;
}
