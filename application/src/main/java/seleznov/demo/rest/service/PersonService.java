package seleznov.demo.rest.service;

import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import seleznov.demo.rest.model.Person;
import seleznov.demo.rest.model.enums.UserRoleEnum;
import seleznov.demo.rest.view.PersonView;

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
