package com.diginamic.demo.repository;

import com.diginamic.demo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createMany(final int count) {
		Person person;

		for (int i = 0; i < count; i++) {
			person = new Person();
			person.setFirstName("First Name");
			person.setLastName("Last Name");

			entityManager.persist(person);
		}

		entityManager.flush();
	}

	@Override
	public void _deleteWhereAnimalsIsEmpty() {
		entityManager
			.createNativeQuery("DELETE FROM Person p WHERE p.id NOT IN (SELECT pa.person_id FROM person_animals pa)")
			.executeUpdate();
	}
}