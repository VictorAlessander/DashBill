package com.app.dashbill.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
public class Person {

    @Id @GeneratedValue
    private long id;

    private String name;

    @OneToMany @JoinColumn(name = "person_id")
    @NonNull
    private List<Debit> debit;

}
