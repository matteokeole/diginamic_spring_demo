package com.diginamic.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;

@Entity
public class Animal {
	public static enum Gender {
		M("Male"),
		F("Female");

		final String value;

		private Gender(final String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@ManyToOne
	@JoinColumn(name="species_id")
	private Species species;

	@Enumerated(EnumType.STRING)
	@Column(name="sex")
	private Gender gender;

	private String color;

	@ManyToMany(mappedBy="animals")
	@JsonIgnore
	private List<Person> persons;

	public Animal() {}

	public Animal(final String name, final Species species, final Gender gender, final String color) {
		this.name = name;
		this.species = species;
		this.gender = gender;
		this.color = color;
	}

	@Override
	public String toString() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(final Species species) {
		this.species = species;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(final List<Person> persons) {
		this.persons = persons;
	}
}