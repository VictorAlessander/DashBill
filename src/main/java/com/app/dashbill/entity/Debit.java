package com.app.dashbill.entity;


import com.app.dashbill.enums.CategoryEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


@Entity
@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
public class Debit {

    @Id
    @GeneratedValue
    private long id;
    private BigInteger balance;
    private Date date;
    private CategoryEnum category;

    @ManyToOne(cascade = CascadeType.ALL) @NonNull
    private Person person;
}
