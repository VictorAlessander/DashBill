package com.app.dashbill.entity;


import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.dashbill.enums.CategoryEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name="debits")
public class Debit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="balance")
    @NotNull
    private BigInteger balance;
    
    @Column(name="date")
    @NotNull
    private LocalDate date;
    
    @Column(name="category")
    @NotNull
    private CategoryEnum category;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id", nullable=false)
    @JsonBackReference
    private Person person;

}
