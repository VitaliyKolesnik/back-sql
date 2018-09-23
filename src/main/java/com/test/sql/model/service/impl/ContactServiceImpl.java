package com.test.sql.model.service.impl;

import com.test.sql.model.entity.Contact;
import com.test.sql.model.repository.ContactRepository;
import com.test.sql.model.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContactServiceImpl implements ContactsService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Set<Contact> findByRegex() {
        return null;
    }
}
