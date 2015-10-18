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
import seleznov.demo.rest.service.PersonService;
import seleznov.demo.rest.view.PersonView;

import java.util.List;

/**
 * Created by illcko
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET, value = "{role}")
    //@ApiOperation - annotation for Swagger
    @ApiOperation(value = "Returns person list by role", response = Person.class, responseContainer = "List")
    public List<PersonView> getPersonsByRole(/*for swagger*/@ApiParam(value = "role", allowableValues = "USER,MODERATOR", required = true) @PathVariable String role) {
        return personService.getPersonsByRole(UserRoleEnum.valueOf(role));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns person list", response = Person.class, responseContainer = "List")
    public List<PersonView> getPersons() {
        return personService.getPersons();
    }

    @RequestMapping(method = RequestMethod.POST, value = "{role}")
    @ApiOperation(value = "Create person", response = String.class)
    public ResponseEntity createPerson(/*for swagger*/@ApiParam(value = "role", allowableValues = "USER,MODERATOR", required = true) @PathVariable String role,
                                       @RequestBody PersonView personView){
        personView.setRole(UserRoleEnum.valueOf(role));
        PersonView createdPerson = personService.createPerson(personView);
        return new ResponseEntity<PersonView>(createdPerson, HttpStatus.OK);
    }
}
