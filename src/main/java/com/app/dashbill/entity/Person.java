package com.app.dashbill.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
public class Person {

    @Id @GeneratedValue
    private long id;

    private String name;

    @OneToOne @JoinColumn(name = "debit")
    @NonNull
    private Debit debit;

}
