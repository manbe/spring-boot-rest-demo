package com.seleznov.demo.restapp.service;

import com.seleznov.demo.restapp.model.enums.UserRoleEnum;
import com.seleznov.demo.restapp.rest.dto.PersonView;
import com.seleznov.demo.restapp.model.Person;

import java.util.List;

/**
 * Created by illcko
 */
public interface PersonService {

    PersonView createPersonView(Person person);

    List<PersonView> getPersonsByRole(UserRoleEnum role);

    List<PersonView> getPersons();

    PersonView createPerson(PersonView personView);

}
