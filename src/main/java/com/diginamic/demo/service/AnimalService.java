package com.diginamic.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.demo.entity.Animal;
import com.diginamic.demo.entity.Species;
import com.diginamic.demo.repository.AnimalRepository;

@Service
public class AnimalService {
	@Autowired
	private AnimalRepository animalRepository;

	public List<Animal> findAll() {
		return animalRepository.findAll();
	}

	public List<Animal> findBySpecies(final Species species) {
		return animalRepository.findBySpecies(species);
	}

	public Optional<Animal> find(final Integer id) {
		return animalRepository.findById(id);
	}

	public void create(final Animal animal) {
		animalRepository.save(animal);
	}

	public void update(final Animal animal) {
		animalRepository.save(animal);
	}

	public void delete(final Animal animal) {
		animalRepository.delete(animal);
	}
}