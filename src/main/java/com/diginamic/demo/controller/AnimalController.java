package com.diginamic.demo.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.demo.entity.Animal;
import com.diginamic.demo.service.AnimalService;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
	@Autowired
	private AnimalService animalService;

	@GetMapping
	public Page<Animal> findAll(final Pageable pageable) {
		return animalService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Animal find(@PathVariable("id") final Integer id) {
		return animalService
			.find(id)
			.orElseThrow(EntityNotFoundException::new);
	}

	@PostMapping
	public void create(@RequestBody @Valid final Animal animal) {
		animalService.create(animal);
	}

	@PutMapping
	public void update(@RequestBody @Valid final Animal animal) {
		animalService.update(animal);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") final Integer id) {
		final Animal animal = animalService.find(id).orElseThrow(EntityNotFoundException::new);

		animalService.delete(animal);
	}
}