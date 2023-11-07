package com.diginamic.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	private int age;

	@ManyToMany
	@JoinTable(
		name="person_animals",
		joinColumns=@JoinColumn(name="person_id"),
		inverseJoinColumns=@JoinColumn(name="animals_id")
	)
	@Column(name="id_person")
	private List<Animal> animals;

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

	public List<Animal> getPets() {
		return animals;
	}

	public void setPets(final List<Animal> pets) {
		this.animals = pets;
	}
}