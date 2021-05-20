package fr.solutec.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Categorie;

public interface CategorieRepository extends CrudRepository<Categorie, Long>{
	
	@Query("SELECT c FROM Categorie c ORDER BY c.libelle")
	public Iterable<Categorie> getCategorieByAlphabetical();
	
}
