package seleznov.demo.rest.repository;

import org.springframework.data.repository.CrudRepository;
import seleznov.demo.rest.model.Person;
import seleznov.demo.rest.model.enums.UserRoleEnum;

import java.util.List;

/**
 * Created by illcko
 */
public interface PersonRepository  extends CrudRepository<Person, Long> {
    List<Person> findAll();
    List<Person> findByRole(UserRoleEnum role);
}
