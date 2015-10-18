package seleznov.demo.rest.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import seleznov.demo.rest.BaseIntegrationTest;
import seleznov.demo.rest.model.Person;
import seleznov.demo.rest.model.enums.UserRoleEnum;
import seleznov.demo.rest.publisher.RestPublisher;
import seleznov.demo.rest.repository.PersonRepository;
import seleznov.demo.rest.view.PersonView;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by illcko on 13.09.15.
 */
public class PersonControllerTest extends BaseIntegrationTest{

    public static final String PERSON_RESOURCE_URL = "api/person/";
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
        List<PersonView> personList = Arrays.asList(restPublisher.doGet(PersonView[].class, "/" + PERSON_RESOURCE_URL + UserRoleEnum.USER));
        assertEquals(1, personList.size());
        assertEquals("user", personList.get(0).getName());
    }

    @Test
    public void createUser(){
        PersonView person = new PersonView();
        person.setLogin("lol");
        person.setName("lol");
        PersonView createdPersonView = restPublisher.doPost(PERSON_RESOURCE_URL + UserRoleEnum.USER, person, PersonView.class);
        assertEquals("lol", createdPersonView.getName());

        Person createdPerson = personRepository.findOne(createdPersonView.getId());
        assertNotNull(createdPerson.getId());

    }
}
