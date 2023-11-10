package com.diginamic.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.diginamic.demo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {
	public List<Person> findByFirstNameContainsOrLastNameContains(final String firstName, final String lastName);
	public List<Person> findByLastName(final String lastName);
	public List<Person> findByAgeGreaterThanEqual(final int age);

	@Query("SELECT p FROM Person p WHERE p.age BETWEEN :minAge AND :maxAge")
	public List<Person> findByMinAgeAndMaxAge(final int minAge, final int maxAge);
}