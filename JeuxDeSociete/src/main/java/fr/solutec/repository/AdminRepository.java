package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Admin;




public interface AdminRepository extends CrudRepository<Admin, Long>{
	public Optional<Admin> findByUserLogin(String login);
	public Optional<Admin> findByUserId(Long id);
	
	
	@Query(value = "SELECT a FROM Admin a INNER JOIN User u ON a.user.id = u.id WHERE u.login = ?1" )
	public Optional<Admin> isAdmin(String login);
	
}
