package com.seleznov.demo.restapp.service;

import com.seleznov.demo.restapp.model.enums.UserRoleEnum;
import com.seleznov.demo.restapp.rest.dto.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seleznov.demo.restapp.model.Person;
import com.seleznov.demo.restapp.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by illcko
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonView createPersonView(Person person) {
        PersonView personView = new PersonView();
        personView.setRole(person.getRole());
        personView.setName(person.getName());
        personView.setLogin(person.getLogin());
        personView.setId(person.getId());
        return personView;
    }

    public List<PersonView> getPersonsByRole(UserRoleEnum role) {
        List<Person> persons = personRepository.findByRole(role);
        List<PersonView> personViews = new ArrayList<PersonView>();
        for(Person person : persons){
            personViews.add(createPersonView(person));
        }
        return personViews;
    }

    public List<PersonView> getPersons() {
        List<Person> persons = personRepository.findAll();
        List<PersonView> personViews = new ArrayList<PersonView>();
        for(Person person : persons){
            personViews.add(createPersonView(person));
        }

        return personViews;
    }

    public PersonView createPerson(PersonView personView) {
        Person person = new Person();
        person.setLogin(personView.getLogin());
        person.setName(personView.getName());
        person.setRole(personView.getRole());
        person.setPassword(Person.DEFAULT_PASSWORD);

        person = personRepository.save(person);

        return createPersonView(person);
    }
}
