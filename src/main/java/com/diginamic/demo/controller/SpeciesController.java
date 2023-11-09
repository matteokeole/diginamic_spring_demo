package com.diginamic.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(path={"/add"}, method={RequestMethod.GET, RequestMethod.POST})
	public String add(final Model model, final HttpServletRequest request) {
		final Species species = new Species();

		if (request.getMethod().equals("POST")) {
			species.setCommonName(request.getParameter("commonName"));
			species.setLatinName(request.getParameter("latinName"));

			speciesRepository.save(species);

			return "redirect:/species";
		}

		model.addAttribute("species", species);

		return "species/add";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long speciesId, final Model model) {
		final Species species = speciesRepository.findById(speciesId).get();

		model.addAttribute("species", species);

		return "species/show";
	}
}