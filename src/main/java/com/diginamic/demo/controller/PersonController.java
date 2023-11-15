package com.diginamic.demo.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.demo.entity.Person;
import com.diginamic.demo.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	@Autowired
	private PersonService personService;

	@GetMapping
	public Page<Person> findAll(final Pageable pageable) {
		return personService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Person find(@PathVariable("id") final Integer id) {
		return personService
			.find(id)
			.orElseThrow(EntityNotFoundException::new);
	}

	@PostMapping
	public void create(@RequestBody @Valid final Person person) {
		if (person.getId() != null) {
			throw new IllegalArgumentException("Person cannot have an id on creation");
		}

		personService.create(person);
	}

	@PutMapping
	public void update(@RequestBody @Valid final Person person) {
		if (person.getId() == null) {
			throw new IllegalArgumentException("Person must have an id on update");
		}

		personService.update(person);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") final Integer id) {
		final Person person = personService.find(id).orElseThrow(EntityNotFoundException::new);

		personService.delete(person);
	}
}