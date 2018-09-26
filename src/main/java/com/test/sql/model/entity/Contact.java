package com.test.sql.model.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
    }
}
