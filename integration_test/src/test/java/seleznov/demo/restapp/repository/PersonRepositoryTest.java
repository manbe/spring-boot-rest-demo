package seleznov.demo.restapp.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import seleznov.demo.restapp.BaseIntegrationTest;
import seleznov.demo.restapp.model.Person;
import seleznov.demo.restapp.model.enums.UserRoleEnum;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by illcko
 */
//Tests results depends on DB data, so any db changes will influence on results. To make it more flexible you can use oun fill db script
// or make assertion logic more flexible.
public class PersonRepositoryTest extends BaseIntegrationTest{

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testFindAll() throws Exception {
        List<Person> persons = personRepository.findAll();
        assertEquals(2, persons.size());
    }

    @Test
    public void testFindByRole(){
        List<Person> persons = personRepository.findByRole(UserRoleEnum.USER);
        assertEquals("user", persons.get(0).getLogin());

        persons = personRepository.findByRole(UserRoleEnum.MODERATOR);
        assertEquals("Illcko", persons.get(0).getLogin());
    }
}