package com.test.sql.model.service.impl;

import com.test.sql.model.repository.ContactRepository;
import com.test.sql.model.service.ContactsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {

    @Mock
    ContactRepository repository;

    ContactsService contactsService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);

        contactsService = new ContactServiceImpl(repository);



    }

    @Test
    void findByRegexShouldReturnData() {

    }

}