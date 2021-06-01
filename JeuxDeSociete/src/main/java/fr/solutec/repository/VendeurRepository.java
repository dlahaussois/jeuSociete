package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Vendeur;


public interface VendeurRepository extends CrudRepository<Vendeur, Long>{

	public  Optional<Vendeur> findByUserLogin(String login);
	public Optional<Vendeur> findByUserId(Long id);
	
	@Query(value = "SELECT v FROM Vendeur v INNER JOIN User u ON v.user.id = u.id WHERE u.login = ?1" )
	public Optional<Vendeur> isVendeur(String login);
	
}
