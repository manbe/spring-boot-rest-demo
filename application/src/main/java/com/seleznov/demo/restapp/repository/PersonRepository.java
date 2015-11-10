package com.seleznov.demo.restapp.repository;

import com.seleznov.demo.restapp.model.Person;
import com.seleznov.demo.restapp.model.enums.UserRoleEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by illcko
 */
public interface PersonRepository  extends CrudRepository<Person, Long> {
    List<Person> findAll();
    List<Person> findByRole(UserRoleEnum role);
}
