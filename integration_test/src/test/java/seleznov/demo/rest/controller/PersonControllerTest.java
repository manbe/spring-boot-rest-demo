package seleznov.demo.rest.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import seleznov.demo.rest.BaseIntegrationTest;
import seleznov.demo.rest.model.Person;
import seleznov.demo.rest.model.enums.UserRoleEnum;
import seleznov.demo.rest.publisher.RestPublisher;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by illcko on 13.09.15.
 */
public class PersonControllerTest extends BaseIntegrationTest{

    public static final String PERSON_RESOURCE_URL = "api/person/";
    @Autowired
    private RestPublisher restPublisher;

    @Test
    public void testGetAllPersons(){
        List<Person> personList = Arrays.asList(restPublisher.doGet(Person[].class, "/api/person"));
        assertEquals(2, personList.size());
    }

    @Test
    public void testGetUsers(){
        List<Person> personList = Arrays.asList(restPublisher.doGet(Person[].class, "/" + PERSON_RESOURCE_URL + UserRoleEnum.USER));
        assertEquals(1, personList.size());
        assertEquals("user", personList.get(0).getName());
    }

    @Test
    public void createUser(){
        Person person = new Person();
        person.setLogin("lol");
        person.setPassword("lol");
        person.setName("lol");
        Person createdPerson = restPublisher.doPost(PERSON_RESOURCE_URL + UserRoleEnum.USER, person, Person.class);
        assertEquals("lol", createdPerson.getName());

    }
}
