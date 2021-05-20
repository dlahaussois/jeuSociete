package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.HistoriqueLocationSalle;

public interface HistoriqueLocationSalleRepository extends CrudRepository<HistoriqueLocationSalle, Long>{

	@Query("SELECT hls FROM HistoriqueLocationSalle hls WHERE hls.joueur.user.id=?1")
	public Optional<Iterable<HistoriqueLocationSalle>> getHistoryByUserId(Long id);
}
