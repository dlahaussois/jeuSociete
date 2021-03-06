package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Joueur;
import fr.solutec.entities.Vendeur;



public interface JoueurRepository extends CrudRepository<Joueur, Long>{
	public  Optional<Joueur> findByUserLogin(String login);
	public Optional<Joueur> findByUserId(Long id);
	
	@Query(value = "SELECT j FROM Joueur j INNER JOIN User u ON j.user.id = u.id WHERE u.login = ?1" )
	public Optional<Joueur> isJoueur(String login);
	
}
