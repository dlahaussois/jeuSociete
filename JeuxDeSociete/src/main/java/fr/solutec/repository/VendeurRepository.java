package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Vendeur;


public interface VendeurRepository extends CrudRepository<Vendeur, Long>{

	public  Optional<Vendeur> findByUserLogin(String login);
	public Optional<Vendeur> findByUserId(Long id);
	
}
