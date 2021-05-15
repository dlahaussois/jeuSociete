package fr.solutec.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Salle;


public interface SalleRepository extends CrudRepository<Salle, Long>{
	public Optional<Salle> findByNom(String nom);


	
}
