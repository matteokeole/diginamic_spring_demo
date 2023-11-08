package com.diginamic.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diginamic.demo.entity.Species;
import com.diginamic.demo.repository.SpeciesRepository;

@Controller
public class SpeciesController {
	@Autowired
	private SpeciesRepository speciesRepository;

	@GetMapping("/species")
	public String listSpecies(final Model model) {
		final List<Species> species = speciesRepository.findAll();

		model.addAttribute("species", species);

		return "list_species";
	}
}