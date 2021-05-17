package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Jeu;
import fr.solutec.entities.JeuAchat;

public interface JeuAchatRepository extends CrudRepository<JeuAchat, Long>{
	@Query(value="SELECT ja FROM JeuAchat ja WHERE ja.prixAchat = ?1")
	public Optional<Iterable<JeuAchat>> getJeuByPrixAchat(double prixAchat);
	
	@Query(value="SELECT ja FROM JeuAchat ja WHERE ja.prixAchat >= ?1")
	public Optional<Iterable<JeuAchat>> getJeuByMoreThanPrixAchat(double prixAchat);
	
	@Query(value="SELECT ja FROM JeuAchat ja WHERE ja.prixAchat <= ?1")
	public Optional<Iterable<JeuAchat>> getJeuByLessThanPrixAchat(double prixAchat);
	
	@Query(value="SELECT ja FROM JeuAchat ja WHERE ja.prixAchat Between ?1 AND ?2")
	public Optional<Iterable<JeuAchat>> getJeuByBetweenPrixAchat(double prixAchatMin, double prixAchatMax);
}
