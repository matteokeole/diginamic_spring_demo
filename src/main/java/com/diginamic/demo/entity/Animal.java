package com.diginamic.demo.entity;

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

	@ManyToOne
	@JoinColumn(name="species_id")
	private Species species;

	@Enumerated(EnumType.STRING)
	@Column(name="sex")
	private Gender gender;

	private String name;

	private String color;

	@ManyToMany(mappedBy="animals")
	private List<Person> person;

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

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	public List<Person> getPersons() {
		return person;
	}

	public void setPersons(final List<Person> persons) {
		this.person = persons;
	}
}