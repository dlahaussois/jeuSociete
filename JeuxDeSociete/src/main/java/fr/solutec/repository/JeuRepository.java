package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Jeu;

public interface JeuRepository extends CrudRepository<Jeu, Long>{
	
	public Optional<Jeu> findByNom(String nom);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.nom LIKE %?1%")
	public Optional<Iterable<Jeu>> getByNom(String nom);
		
	
}
