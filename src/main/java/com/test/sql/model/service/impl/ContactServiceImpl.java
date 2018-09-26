package com.test.sql.model.service.impl;

import com.test.sql.model.entity.Contact;
import com.test.sql.model.repository.ContactRepository;
import com.test.sql.model.service.ContactsService;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactServiceImpl implements ContactsService {

    private final ContactRepository contactRepository;

    private final int PAGE_SIZE = 500;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Set<Contact> findByRegex(String regex) throws Exception {
        Set<Contact> result = new HashSet<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        Pageable pageable = PageRequest.of(0, PAGE_SIZE);
        Page<Contact> contacts = contactRepository.findAll(pageable);

        while (contacts.getContent().size() > 0) {
            for (Contact contact : contacts.getContent()) {
                matcher = pattern.matcher(contact.getName());
                if (!matcher.matches()) result.add(contact);
            }
            pageable = pageable.next();
            contacts = contactRepository.findAll(pageable);
        }

        if (result.size() == 0) throw new Exception("There are no data for this regex.");

        return result;
    }

    @Override
    public Contact saveContact(Contact contact) {

        return contactRepository.save(contact);
    }
}
