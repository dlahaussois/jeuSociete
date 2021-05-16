package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.Vendeur;


public interface VendeurRepository extends CrudRepository<Vendeur, Long>{

	public Iterable<Vendeur> findByUserLogin(String login);
	
}
