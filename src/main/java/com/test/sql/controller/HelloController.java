package com.test.sql.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.test.sql.model.entity.Contact;
import com.test.sql.model.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    private final ContactsService contactsService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public HelloController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping(path = "/contacts")
    public ResponseEntity getContacts(@RequestParam String nameFilter) {
        try {
            Set<Contact> response = contactsService.findByRegex(nameFilter);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(mapper.createObjectNode().put("message", e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/contacts")
    public ResponseEntity saveContacts(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactsService.saveContact(contact), HttpStatus.OK);
    }
}
