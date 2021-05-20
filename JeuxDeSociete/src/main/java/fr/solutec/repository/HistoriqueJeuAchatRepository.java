package fr.solutec.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.HistoriqueJeuAchat;
import fr.solutec.entities.HistoriqueJeuLocation;

public interface HistoriqueJeuAchatRepository extends CrudRepository<HistoriqueJeuAchat, Long>{

	
}
