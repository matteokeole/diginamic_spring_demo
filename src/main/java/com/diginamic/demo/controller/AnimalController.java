package com.diginamic.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginamic.demo.entity.Animal;
import com.diginamic.demo.repository.AnimalRepository;

@Controller
@RequestMapping("/animals")
public class AnimalController {
	@Autowired
	private AnimalRepository animalRepository;

	@GetMapping("")
	public String list(final Model model) {
		final List<Animal> animals = animalRepository.findAll();

		model.addAttribute("animals", animals);

		return "animal/list";
	}

	@GetMapping(name="new", path="/new")
	public String _new(final Model model) {
		final Animal animal = new Animal();

		model.addAttribute("animal", animal);

		return "animal/new";
	}

	@GetMapping(name="edit", path="/{id}")
	public String edit(@PathVariable("id") final Integer id, final Model model) {
		final Animal animal = animalRepository.findById(id).get();

		model.addAttribute("animal", animal);

		return "animal/edit";
	}

	@PostMapping(name="save", path="/save")
	public String save(final Animal animal) {
		animalRepository.save(animal);

		return "redirect:/animal";
	}
}