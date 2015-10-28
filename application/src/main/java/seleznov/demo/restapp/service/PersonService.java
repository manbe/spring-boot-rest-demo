package seleznov.demo.restapp.service;

import seleznov.demo.restapp.model.Person;
import seleznov.demo.restapp.model.enums.UserRoleEnum;
import seleznov.demo.restapp.rest.dto.PersonView;

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
