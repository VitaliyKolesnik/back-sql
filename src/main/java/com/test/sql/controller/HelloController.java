package com.test.sql.controller;

import com.test.sql.model.entity.Contact;
import com.test.sql.model.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    private final ContactsService contactsService;

    @Autowired
    public HelloController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping(path = "/contacts")
    public ResponseEntity getContacts(@RequestParam String nameFilter) {

        try {
            Set<Contact> response = contactsService.findByRegex();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
