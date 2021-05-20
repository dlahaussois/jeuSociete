package fr.solutec.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.HistoriqueJeuLocation;

public interface HistoriqueJeuLocationRepository extends CrudRepository<HistoriqueJeuLocation, Long>{

	@Query("SELECT hjl FROM HistoriqueJeuLocation hjl WHERE hjl.joueur.user.id=?1")
	public Optional<Iterable<HistoriqueJeuLocation>> getByUserId(Long id);
	
}
