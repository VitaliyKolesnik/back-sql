package com.test.sql.model.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.sql.model.entity.Contact;
import com.test.sql.model.repository.ContactRepository;
import com.test.sql.model.service.ContactsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class ContactServiceImplTest {

    @Mock
    private ContactRepository repository;

    private ContactsService contactsService;
    private ObjectMapper mapper = new ObjectMapper();
    private Page<Contact> contacts;

    @BeforeEach
    void init() throws IOException {
        MockitoAnnotations.initMocks(this);

        contactsService = new ContactServiceImpl(repository);

        URL url = this.getClass().getClassLoader().getResource("ContactsMock.json");
        contacts = new PageImpl<>(mapper.readValue(url, new TypeReference<List<Contact>>(){}));

        Pageable pageable = PageRequest.of(0, 500);
        when(repository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(new LinkedList<>()));
        when(repository.findAll(pageable)).thenReturn(contacts);
    }

    @Test
    void findByRegexShouldReturnData() {

        try {
            List<Contact> result = contactsService.findByRegex("^[134].*$");
            assertEquals(contacts.getContent().get(1), result.get(0));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findByRegexShouldThrowExceptionIfNoResult() {

        Exception e = Assertions.assertThrows(Exception.class, () -> contactsService.findByRegex("^[1234].*$"));

        assertEquals("There are no data for this regex.", e.getMessage());
    }

}