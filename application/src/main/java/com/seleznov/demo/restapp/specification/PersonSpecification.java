package com.seleznov.demo.restapp.specification;

import org.springframework.data.jpa.domain.Specification;
import com.seleznov.demo.restapp.model.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by illcko
 */
public class PersonSpecification implements Specification<Person> {
    
    public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
