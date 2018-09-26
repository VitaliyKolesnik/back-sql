package com.test.sql.model.service;

import com.test.sql.model.entity.Contact;

import java.util.List;
import java.util.Set;

public interface ContactsService {
    List<Contact> findByRegex(String regex) throws Exception;

    Contact saveContact(Contact contact);
}
