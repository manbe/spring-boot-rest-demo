package com.seleznov.demo.restapp.rest.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.seleznov.demo.restapp.BaseIntegrationTest;
import com.seleznov.demo.restapp.model.Person;
import com.seleznov.demo.restapp.model.enums.UserRoleEnum;
import com.seleznov.demo.restapp.publisher.RestPublisher;
import com.seleznov.demo.restapp.repository.PersonRepository;
import com.seleznov.demo.restapp.rest.dto.PersonView;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by illcko on 13.09.15.
 */
public class PersonControllerTest extends BaseIntegrationTest{

    public static final String PERSON_RESOURCE_URL = "api/person/";
    public static final String ROLE = "?role=";
    @Autowired
    private RestPublisher restPublisher;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testGetAllPersons(){
        List<PersonView> personList = Arrays.asList(restPublisher.doGet(PersonView[].class, "/api/person"));
        assertEquals(2, personList.size());
    }

    @Test
    public void testGetUsers(){
        List<PersonView> personList = Arrays.asList(restPublisher.doGet(PersonView[].class, "/" + PERSON_RESOURCE_URL + ROLE + UserRoleEnum.USER));
        assertEquals(1, personList.size());
        assertEquals("user", personList.get(0).getName());
    }

    @Test
    public void createUser(){
        PersonView person = new PersonView();
        person.setLogin("lol");
        person.setName("lol");
        person.setRole(UserRoleEnum.MODERATOR);
        PersonView createdPersonView = restPublisher.doPost(PERSON_RESOURCE_URL, person, PersonView.class);
        assertEquals("lol", createdPersonView.getName());

        Person createdPerson = personRepository.findOne(createdPersonView.getId());
        assertNotNull(createdPerson.getId());

    }
}
