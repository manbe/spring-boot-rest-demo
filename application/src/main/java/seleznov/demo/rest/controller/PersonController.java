package seleznov.demo.rest.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seleznov.demo.rest.model.Person;
import seleznov.demo.rest.model.enums.UserRoleEnum;
import seleznov.demo.rest.repository.PersonRepository;

import java.util.List;

/**
 * Created by illcko
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET, value = "{role}")
    //@ApiOperation - annotation for Swagger
    @ApiOperation(value = "Returns person list by role", response = Person.class, responseContainer = "List")
    public List<Person> getPersonsByRole(/*for swagger*/@ApiParam(value = "role", allowableValues = "USER,MODERATOR", required = true) @PathVariable String role) {
        return personRepository.findByRole(UserRoleEnum.valueOf(role));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns person list", response = Person.class, responseContainer = "List")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "{role}")
    @ApiOperation(value = "Create person", response = String.class)
    public ResponseEntity createPerson(/*for swagger*/@ApiParam(value = "role", allowableValues = "USER,MODERATOR", required = true) @PathVariable String role,
                                       @RequestBody Person person){
        person.setRole(UserRoleEnum.valueOf(role));
        person = personRepository.save(person);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
}
