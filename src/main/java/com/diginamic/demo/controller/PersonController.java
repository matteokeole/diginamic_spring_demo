package com.diginamic.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginamic.demo.entity.Person;
import com.diginamic.demo.repository.PersonRepository;

@Controller
@RequestMapping(name="person_", path="/persons")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;

	@GetMapping("")
	public String list(final Model model) {
		final List<Person> persons = personRepository.findAll();

		model.addAttribute("persons", persons);

		return "person/list";
	}

	@GetMapping(name="new", path="/new")
	public String _new(final Model model) {
		final Person person = new Person();

		model.addAttribute("person", person);

		return "person/new";
	}

	@GetMapping(name="edit", path="/{id}")
	public String edit(@PathVariable("id") final Integer id, final Model model) {
		final Person person = personRepository.findById(id).get();

		model.addAttribute("person", person);

		return "person/edit";
	}

	@PostMapping(name="save", path="/save")
	public String save(final Person person) {
		personRepository.save(person);

		return "redirect:/persons";
	}
}