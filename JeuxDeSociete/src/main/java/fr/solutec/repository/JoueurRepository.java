package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Joueur;
import fr.solutec.entities.Vendeur;



public interface JoueurRepository extends CrudRepository<Joueur, Long>{
	public  Optional<Joueur> findByUserLogin(String login);
	public Optional<Joueur> findByUserId(Long id);
	
}
