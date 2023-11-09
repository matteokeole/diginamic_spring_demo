package com.diginamic.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginamic.demo.entity.Species;
import com.diginamic.demo.repository.SpeciesRepository;

@Controller
@RequestMapping("/species")
public class SpeciesController {
	@Autowired
	private SpeciesRepository speciesRepository;

	@GetMapping("")
	public String list(final Model model) {
		final List<Species> species = speciesRepository.findAll();

		model.addAttribute("species", species);

		return "species/list";
	}

	@GetMapping(name="add", path="/add")
	public String add(final Model model) {
		final Species species = new Species();

		model.addAttribute("species", species);

		return "species/add";
	}

	@GetMapping(name="show", path="/{id}")
	public String show(@PathVariable("id") Long id, final Model model) {
		final Species species = speciesRepository.findById(id).get();

		model.addAttribute("species", species);

		return "species/show";
	}

	@PostMapping(name="save", path="/save")
	public String save(final Species species) {
		speciesRepository.save(species);

		return "redirect:/species";
	}
}