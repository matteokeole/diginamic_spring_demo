package com.diginamic.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.demo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	public List<Person> findByFirstNameContainsOrLastNameContains(final String firstName, final String lastName);
	public List<Person> findByLastName(final String lastName);
	public List<Person> findByAgeGreaterThanEqual(final Integer age);
}