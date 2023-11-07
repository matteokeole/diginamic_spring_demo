package com.diginamic.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="animal")
public class Animal {
	private static enum Gender {
		MALE("Male"),
		FEMALE("Female");

		final String value;

		private Gender(final String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name="species_id")
	private Species species;

	@Enumerated(EnumType.STRING)
	@JoinColumn(columnDefinition="sex")
	private Gender gender;

	private String name;

	private String color;

	@ManyToMany(mappedBy="animals")
	private List<Person> owners;

	@Override
	public String toString() {
		return "%s %s (%s)".formatted(gender, name, species);
	}

	public Integer getId() {
		return id;
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

	public List<Person> getOwners() {
		return owners;
	}

	public void setOwners(final List<Person> owners) {
		this.owners = owners;
	}
}