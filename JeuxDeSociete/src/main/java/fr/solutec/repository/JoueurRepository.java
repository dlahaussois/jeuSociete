package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Joueur;



public interface JoueurRepository extends CrudRepository<Joueur, Long>{
	public Optional<Joueur> findByUserLogin(String login);
}
