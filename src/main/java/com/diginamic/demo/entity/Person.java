package com.diginamic.demo.entity;

import jakarta.persistence.CascadeType;
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
	private int id;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	private int age;

	@ManyToMany(cascade=CascadeType.DETACH)
	private List<Animal> animals = new ArrayList<>();

	public Person() {}

	public Person(final String firstName, final String lastName, final int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "%s %s".formatted(firstName, lastName);
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
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