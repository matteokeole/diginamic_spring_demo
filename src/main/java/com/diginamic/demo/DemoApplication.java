package com.diginamic.demo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.diginamic.demo.repository.AnimalRepository;
import com.diginamic.demo.repository.PersonRepository;
import com.diginamic.demo.repository.SpeciesRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private SpeciesRepository speciesRepository;

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(final String... args) {
		System.out.println("Animal table size: %d".formatted(animalRepository.findAll().size()));
		System.out.println("Person table size: %d".formatted(personRepository.findAll().size()));
		System.out.println("Species table size: %d".formatted(speciesRepository.findAll().size()));

		// personRepository.deleteWhereAnimalsIsEmpty();
		personRepository.insertMany(3);
	}
}