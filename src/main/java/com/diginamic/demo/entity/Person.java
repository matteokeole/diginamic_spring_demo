package com.diginamic.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	private int age;

	public Person() {}

	public Person(final String firstName, final String lastName, final int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@ManyToMany
	private List<Animal> animals = new ArrayList<>();

	@Override
	public String toString() {
		return "%s %s, %d".formatted(firstName, lastName, age);
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(final List<Animal> animals) {
		this.animals = animals;
	}
}