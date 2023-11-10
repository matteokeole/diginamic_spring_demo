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

import com.diginamic.demo.entity.Species;
import com.diginamic.demo.service.SpeciesService;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {
	@Autowired
	private SpeciesService speciesService;

	@GetMapping
	public Page<Species> findAll(final Pageable pageable) {
		return speciesService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Species find(@PathVariable("id") final Integer id) {
		return speciesService
			.find(id)
			.orElseThrow(EntityNotFoundException::new);
	}

	@PostMapping
	public void create(@RequestBody @Valid final Species species) {
		speciesService.create(species);
	}

	@PutMapping
	public void update(@RequestBody @Valid final Species species) {
		speciesService.update(species);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") final Integer id) {
		final Species species = speciesService.find(id).orElseThrow(EntityNotFoundException::new);

		speciesService.delete(species);
	}
}