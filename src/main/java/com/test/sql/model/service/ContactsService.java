package com.test.sql.model.service;

import com.test.sql.model.entity.Contact;

import java.util.Set;

public interface ContactsService {
    Set<Contact> findByRegex();
}
