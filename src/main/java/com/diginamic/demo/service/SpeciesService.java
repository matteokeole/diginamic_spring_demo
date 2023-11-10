package com.diginamic.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.demo.entity.Species;
import com.diginamic.demo.repository.SpeciesRepository;

@Service
public class SpeciesService {
	@Autowired
	private SpeciesRepository speciesRepository;

	public Page<Species> findAll(final Pageable pageable) {
		return speciesRepository.findAll(pageable);
	}

	public List<Species> findByLatinNameIgnoreCaseContains(final String latinName) {
		return speciesRepository.findByLatinNameIgnoreCaseContains(latinName);
	}

	public Optional<Species> find(final Integer id) {
		return speciesRepository.findById(id);
	}

	public Optional<Species> findFirstByCommonName(final String commonName) {
		return Optional.of(speciesRepository.findFirstByCommonName(commonName));
	}

	public void create(final Species species) {
		speciesRepository.save(species);
	}

	public void update(final Species species) {
		speciesRepository.save(species);
	}

	public void delete(final Species species) {
		speciesRepository.delete(species);
	}
}