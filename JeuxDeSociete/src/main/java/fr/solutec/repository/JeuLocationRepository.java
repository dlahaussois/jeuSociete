package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.JeuLocation;

public interface JeuLocationRepository extends CrudRepository<JeuLocation, Long>{
	@Query("SELECT jl FROM JeuLocation jl WHERE jl.lejeu.id = ?1")
	public Optional<JeuLocation> getJeuLocationByIdJeu(Long id);
}
