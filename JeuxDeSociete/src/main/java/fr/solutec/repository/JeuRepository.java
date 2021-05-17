package fr.solutec.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.Jeu;
import fr.solutec.entities.JeuAchat;
import fr.solutec.entities.Marque;

public interface JeuRepository extends CrudRepository<Jeu, Long>{
	
	public Optional<Jeu> findByNom(String nom);
	
	
	@Query(value="SELECT j FROM Jeu j WHERE lower(j.nom) LIKE %?1%")
	public Optional<Iterable<Jeu>> getJeuByNom(String nom);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.AgeMin = ?1")
	public Optional<Iterable<Jeu>> getJeuByAgeMin(int ageMin);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.AgeMin >= ?1")
	public Optional<Iterable<Jeu>> getJeuByMoreThanAgeMin(int ageMin);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.AgeMin <= ?1")
	public Optional<Iterable<Jeu>> getJeuByLessThanAgeMin(int ageMin);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.AgeMin BETWEEN ?1 AND ?2")
	public Optional<Iterable<Jeu>> getJeuByBetweenAgeMin(int ageMinMin, int ageMinMax);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.categorieDuJeu = ?1")
	public Optional<Iterable<Jeu>> getJeuByCategorie(Categorie categorie);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.marqueDuJeu = ?1")
	public Optional<Iterable<Jeu>> getJeuByMarque(Marque marque);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.TempsDeJeu = ?1")
	public Optional<Iterable<Jeu>> getJeuByTempsDeJeu(int TempsDeJeu);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.TempsDeJeu >= ?1")
	public Optional<Iterable<Jeu>> getJeuByMoreThanTempsDeJeu(int TempsDeJeu);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.TempsDeJeu <= ?1")
	public Optional<Iterable<Jeu>> getJeuByLessThanTempsDeJeu(int TempsDeJeu);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.TempsDeJeu BETWEEN ?1 AND ?2")
	public Optional<Iterable<Jeu>> getJeuByBetweenTempsDeJeu(int TempsDeJeuMin, int TempsDeJeuMax);
	
	@Query(value="SELECT j FROM Jeu j WHERE j.NiveauDifficulte = ?1")
	public Optional<Iterable<Jeu>> getByNiveauDifficulte(String difficulte);
	
}
