package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Avis;

public interface AvisRepository extends CrudRepository<Avis, Long>{

	public List<Avis> findByJeuId(Long id);
	public List<Avis> findByUserId(Long id);
	
}
