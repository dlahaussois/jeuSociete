package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.JeuLocation;

public interface JeuLocationRepository extends CrudRepository<JeuLocation, Long>{
	
}
