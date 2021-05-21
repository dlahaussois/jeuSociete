package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Jeu;
import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query(value="SELECT u FROM User u WHERE login=?1 AND password= ?2")
	public Optional<User> connect(String login, String password);
	
	
	
	public Optional<User> findByLogin(String login);
	
}
