package com.test.sql.model.entity;


import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "contacts")
public class Contact {

    private long id;

    private String name;
}
