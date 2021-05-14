package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Jeu;

public interface JeuRepository extends CrudRepository<Jeu, Long>{
	
	
}
