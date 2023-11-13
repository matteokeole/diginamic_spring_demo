package com.diginamic.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
public class Species {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="common_name")
	@NotBlank
	@Size(max=255)
	private String commonName;

	@Column(name="latin_name")
	@NotBlank
	@Size(max=255)
	private String latinName;

	@OneToMany(mappedBy="species")
	@JsonIgnore
	private List<Animal> animals;

	public Species() {}

	public Species(final String commonName, final String latinName) {
		this.commonName = commonName;
		this.latinName = latinName;
	}

	@Override
	public String toString() {
		return commonName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(final String commonName) {
		this.commonName = commonName;
	}

	public String getLatinName() {
		return latinName;
	}

	public void setLatinName(final String latinName) {
		this.latinName = latinName;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(final List<Animal> animals) {
		this.animals = animals;
	}
}