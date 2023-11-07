package com.diginamic.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.demo.entity.Animal;
import com.diginamic.demo.entity.Species;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	public List<Animal> findBySpecies(final Species species);
}