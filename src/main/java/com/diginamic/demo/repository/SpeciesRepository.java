package com.diginamic.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.demo.entity.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
	public Species findFirstByCommonName(final String commonName);
	public List<Species> findByLatinNameIgnoreCaseContains(final String latinName);
}