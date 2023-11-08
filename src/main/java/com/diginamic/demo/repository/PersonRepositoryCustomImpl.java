package com.diginamic.demo.repository;

import com.diginamic.demo.entity.Person;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Locale;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	public void insertMany(final int count) {
		final Faker faker = new Faker(new Locale("fr"));

		Person person;

		for (int i = 0; i < count; i++) {
			person = new Person(faker.name().firstName(), faker.name().lastName(), 20 + i);

			entityManager.persist(person);
		}

		entityManager.flush();
	}

	public void deleteWhereAnimalsIsEmpty() {
		entityManager
			.createNativeQuery("DELETE FROM Person p WHERE p.id NOT IN (SELECT pa.person_id FROM person_animals pa)")
			.executeUpdate();
	}
}