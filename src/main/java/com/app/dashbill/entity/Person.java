package com.app.dashbill.entity;


import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "persons")
@Data
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    private String id;

    @NotNull
    private String name;

}
