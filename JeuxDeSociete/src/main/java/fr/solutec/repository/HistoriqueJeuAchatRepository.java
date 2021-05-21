package fr.solutec.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.HistoriqueJeuAchat;
import fr.solutec.entities.HistoriqueJeuLocation;

public interface HistoriqueJeuAchatRepository extends CrudRepository<HistoriqueJeuAchat, Long>{

	@Query("SELECT hja FROM HistoriqueJeuAchat hja WHERE hja.joueur.user.id=?1")
	public Optional<Iterable<HistoriqueJeuAchat>> getByUserId(Long id);
}
