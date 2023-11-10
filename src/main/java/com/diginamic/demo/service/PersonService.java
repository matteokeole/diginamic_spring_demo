package com.diginamic.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.demo.entity.Person;
import com.diginamic.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public Page<Person> findAll(final Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	public List<Person> findByFirstNameContainsOrLastNameContains(final String firstName, final String lastName) {
		return personRepository.findByFirstNameContainsOrLastNameContains(firstName, lastName);
	}

	public List<Person> findByLastName(final String lastName) {
		return personRepository.findByLastName(lastName);
	}

	public List<Person> findByAgeGreaterThanEqual(final int age) {
		return personRepository.findByAgeGreaterThanEqual(age);
	}

	public List<Person> findByMinAgeAndMaxAge(final int minAge, final int maxAge) {
		return personRepository.findByMinAgeAndMaxAge(minAge, maxAge);
	}

	public Optional<Person> find(final Integer id) {
		return personRepository.findById(id);
	}

	public void create(final Person person) {
		personRepository.save(person);
	}

	public void createMany(final int count) {
		personRepository.insertMany(count);
	}

	public void update(final Person person) {
		personRepository.save(person);
	}

	public void delete(final Person person) {
		personRepository.delete(person);
	}

	public void deleteNonOwners() {
		personRepository.deleteWhereAnimalsIsEmpty();
	}
}