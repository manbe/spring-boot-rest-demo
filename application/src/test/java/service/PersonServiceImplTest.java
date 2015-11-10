package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import com.seleznov.demo.restapp.model.Person;
import com.seleznov.demo.restapp.model.enums.UserRoleEnum;
import com.seleznov.demo.restapp.repository.PersonRepository;
import com.seleznov.demo.restapp.service.PersonService;
import com.seleznov.demo.restapp.service.PersonServiceImpl;
import com.seleznov.demo.restapp.rest.dto.PersonView;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by illcko
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {

    public static final String NAME = "name";
    public static final UserRoleEnum ROLE = UserRoleEnum.MODERATOR;
    public static final String PASSWORD = "password";
    public static final String LOGIN = "login";
    public static final long ID = 1l;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService = new PersonServiceImpl();


    @Test
    public void testCreatePersonView() throws Exception {
        Person person = getPersonMock();

        PersonView personView = personService.createPersonView(person);
        assertEquals(LOGIN, personView.getLogin());
        assertEquals(ID, personView.getId());
        assertEquals(ROLE, personView.getRole());
        assertEquals(NAME, personView.getName());
    }

    private Person getPersonMock() {
        Person person = new Person();
        person.setName(NAME);
        person.setRole(ROLE);
        person.setPassword(PASSWORD);
        person.setLogin(LOGIN);
        person.setId(ID);
        return person;
    }

    @Test
    public void testGetPersonsByRole() throws Exception {
        Person person = getPersonMock();
        when(personRepository.findByRole(ROLE)).thenReturn(Arrays.asList(person));
        List<PersonView> personViews = personService.getPersonsByRole(ROLE);
        assertEquals(1, personViews.size());

        PersonView personView = personViews.get(0);
        assertEquals(LOGIN, personView.getLogin());
        assertEquals(ID, personView.getId());
        assertEquals(ROLE, personView.getRole());
        assertEquals(NAME, personView.getName());
    }

    @Test
    public void testGetPersons() throws Exception {
        Person person = getPersonMock();
        when(personRepository.findAll()).thenReturn(Arrays.asList(person));

        List<PersonView> personViews = personService.getPersons();
        assertEquals(1, personViews.size());

        PersonView personView = personViews.get(0);
        assertEquals(LOGIN, personView.getLogin());
        assertEquals(ID, personView.getId());
        assertEquals(ROLE, personView.getRole());
        assertEquals(NAME, personView.getName());
    }

    @Test
    public void testCreatePerson() throws Exception {
        PersonView personView = new PersonView();
        personView.setName(NAME);
        personView.setRole(ROLE);
        personView.setLogin(LOGIN);

        when(personRepository.save(any(Person.class))).then(new Answer<Person>() {
            public Person answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                Person person = (Person) args[0];
                person.setId(1l);
                person.setPassword(Person.DEFAULT_PASSWORD);
                return person;
            }
        });

        PersonView createdPerson = personService.createPerson(personView);
        assertEquals(LOGIN, createdPerson.getLogin());
        assertEquals(NAME, createdPerson.getName());
        assertEquals(ROLE, createdPerson.getRole());
        assertNotNull(createdPerson.getId());

    }
}