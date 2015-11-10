package com.seleznov.demo.restapp.rest.controller;

import com.seleznov.demo.restapp.model.enums.UserRoleEnum;
import com.seleznov.demo.restapp.rest.dto.PersonView;
import com.seleznov.demo.restapp.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seleznov.demo.restapp.model.Person;

import java.util.List;

/**
 * Created by illcko
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    //@ApiOperation - annotation for Swagger
    @ApiOperation(value = "Returns person list by role", response = Person.class, responseContainer = "List")
    public List<PersonView> getPersonsByRole(/*for swagger*/@ApiParam(value = "role", allowableValues = "USER,MODERATOR", required = false) @RequestParam(required = false) String role) {
        if (role != null) {
            return personService.getPersonsByRole(UserRoleEnum.valueOf(role));
        }

        return personService.getPersons();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create person", response = String.class)
    public ResponseEntity createPerson(@RequestBody PersonView personView){
        PersonView createdPerson = personService.createPerson(personView);
        return new ResponseEntity<PersonView>(createdPerson, HttpStatus.OK);
    }
}
