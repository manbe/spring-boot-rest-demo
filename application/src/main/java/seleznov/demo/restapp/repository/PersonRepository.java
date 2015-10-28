package seleznov.demo.restapp.repository;

import org.springframework.data.repository.CrudRepository;
import seleznov.demo.restapp.model.Person;
import seleznov.demo.restapp.model.enums.UserRoleEnum;

import java.util.List;

/**
 * Created by illcko
 */
public interface PersonRepository  extends CrudRepository<Person, Long> {
    List<Person> findAll();
    List<Person> findByRole(UserRoleEnum role);
}
