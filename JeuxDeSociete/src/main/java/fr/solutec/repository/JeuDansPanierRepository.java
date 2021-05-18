package fr.solutec.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import fr.solutec.entities.JeuDansPanier;

public interface JeuDansPanierRepository extends CrudRepository<JeuDansPanier, Long>{
	@Query("SELECT jdp FROM JeuDansPanier jdp ")
	public Optional<Iterable<JeuDansPanier>> getByUserId(Long id);

}
