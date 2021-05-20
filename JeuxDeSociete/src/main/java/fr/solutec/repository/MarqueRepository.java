package fr.solutec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Marque;

public interface MarqueRepository extends CrudRepository<Marque, Long>{
	
	@Query("SELECT m FROM Marque m ORDER BY m.libelle")
	public Iterable<Marque> getMarqueByAlphabetical();
}
