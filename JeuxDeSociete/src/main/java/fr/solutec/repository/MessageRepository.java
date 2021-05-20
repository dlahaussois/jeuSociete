package fr.solutec.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Message;



public interface MessageRepository extends CrudRepository<Message, Long>{
	//public List<Message> findByExpediteurId(Long id);
	public List<Message> findByForumId(Long id);
	public List<Message> findByForumSujet(String sujet);
	public List<Message> findByPriveeIsFalse();
	public List<Message> findByPriveeIsTrue();
	@Query(value = "SELECT m FROM Message m inner join User u ON m.expediteur.id=u.id WHERE m.privee=false AND u.id=?1 ")
	public Optional<Iterable<Message>> trouverPublicByExpediteurId(Long id);
	@Query(value = "SELECT m FROM Message m inner join User u ON m.expediteur.id=u.id WHERE m.privee=true AND u.id=?1 ")
	public Optional<Iterable<Message>> trouverPriveByExpediteurId(Long id);
	
	}


