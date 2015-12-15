package com.seleznov.demo.restapp.rest.controller;

import com.seleznov.demo.restapp.BaseIntegrationTest;
import com.seleznov.demo.restapp.model.enums.UserRoleEnum;
import com.seleznov.demo.restapp.publisher.RestPublisher;
import com.seleznov.demo.restapp.repository.PersonRepository;
import com.seleznov.demo.restapp.rest.dto.PersonView;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by illcko
 */
public class ZzzTest  extends BaseIntegrationTest {

    public static final String PERSON_RESOURCE_URL = "api/person/";
    public static final String ROLE = "?role=";
    @Autowired
    private RestPublisher restPublisher;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testGetUsers(){
        List<PersonView> personList = Arrays.asList(restPublisher.doGet(PersonView[].class, "/" + PERSON_RESOURCE_URL + ROLE + UserRoleEnum.USER));
        assertEquals(1, personList.size());
        assertEquals("user", personList.get(0).getName());
    }
}
