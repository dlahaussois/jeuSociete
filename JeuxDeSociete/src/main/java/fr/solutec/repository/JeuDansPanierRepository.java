package fr.solutec.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import fr.solutec.entities.JeuDansPanier;

public interface JeuDansPanierRepository extends CrudRepository<JeuDansPanier, Long>{
	@Query("SELECT jdp FROM JeuDansPanier jdp WHERE jdp.user.id=?1")
	public Optional<Iterable<JeuDansPanier>> getByUserId(Long id);

	@Query("SELECT jdp FROM JeuDansPanier jdp WHERE jdp.jeuAchat.id=?1")
	public Optional<Iterable<JeuDansPanier>> getByJeuAchatId(Long id);
	
}
