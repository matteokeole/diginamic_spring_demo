package com.diginamic.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginamic.demo.entity.Species;
import com.diginamic.demo.repository.SpeciesRepository;

import jakarta.validation.Valid;

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

	@GetMapping(name="new", path="/new")
	public String _new(final Model model) {
		final Species species = new Species();

		model.addAttribute("species", species);

		return "species/new";
	}

	@GetMapping(name="edit", path="/{id}")
	public String edit(@PathVariable("id") final Integer id, final Model model) {
		final Species species = speciesRepository.findById(id).get();

		model.addAttribute("species", species);

		return "species/edit";
	}

	@PostMapping(name="save", path="/save")
	@Valid
	public String save(@Valid final Species species, final BindingResult result) {
		if (result.hasErrors()) {
			return "species/new";
		}

		speciesRepository.save(species);

		return "redirect:/species";
	}

	@DeleteMapping(name="delete", path="/delete")
	public String delete(final Species species) {
		speciesRepository.delete(species);

		return "redirect:/species";
	}
}