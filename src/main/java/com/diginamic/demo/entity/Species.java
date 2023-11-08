package com.diginamic.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Species {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="common_name")
	private String commonName;

	@Column(name="latin_name")
	private String latinName;

	@OneToMany(mappedBy="species")
	private List<Animal> animals;

	@Override
	public String toString() {
		return "%s (lat. %s)".formatted(commonName, latinName);
	}

	public Integer getId() {
		return id;
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