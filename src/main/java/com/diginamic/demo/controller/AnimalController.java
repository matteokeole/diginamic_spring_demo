package com.diginamic.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginamic.demo.entity.Animal;
import com.diginamic.demo.entity.Species;
import com.diginamic.demo.entity.Animal.Gender;
import com.diginamic.demo.repository.AnimalRepository;
import com.diginamic.demo.repository.SpeciesRepository;

@Controller
@RequestMapping("/animals")
public class AnimalController {
	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private SpeciesRepository speciesRepository;

	@GetMapping("")
	public String list(final Model model) {
		final List<Animal> animals = animalRepository.findAll();

		model.addAttribute("animals", animals);

		return "animal/list";
	}

	@GetMapping(name="new", path="/new")
	public String _new(final Model model) {
		final Animal animal = new Animal();
		final List<Species> species = speciesRepository.findAll();
		final List<Gender> genders = List.of(Gender.values());

		model.addAttribute("animal", animal);
		model.addAttribute("species", species);
		model.addAttribute("genders", genders);

		return "animal/new";
	}

	@GetMapping(name="edit", path="/{id}")
	public String edit(@PathVariable("id") final Integer id, final Model model) {
		final Animal animal = animalRepository.findById(id).get();
		final List<Species> species = speciesRepository.findAll();
		final List<Gender> genders = List.of(Gender.values());

		model.addAttribute("animal", animal);
		model.addAttribute("species", species);
		model.addAttribute("genders", genders);

		return "animal/edit";
	}

	@PostMapping(name="save", path="/save")
	public String save(final Animal animal) {
		System.out.println(animal.getGender());
		animalRepository.save(animal);

		return "redirect:/animals";
	}

	@DeleteMapping(name="delete", path="/delete")
	public String delete(final Animal animal) {
		animalRepository.delete(animal);

		return "redirect:/animals";
	}
}