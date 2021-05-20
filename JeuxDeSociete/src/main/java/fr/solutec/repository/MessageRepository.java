package fr.solutec.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Jeu;
import fr.solutec.entities.Message;
import fr.solutec.entities.User;



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
	
	public Optional<Iterable<Message>> findByDestinataireId(Long id);
	
	public Optional<Iterable<Message>> findByExpediteurLogin(String login);
	
	@Query(value = "SELECT m FROM Message m WHERE m.destinataire.id=?1 AND m.expediteur.id=?2")
	public Optional<Iterable<Message>> trouverMessagesDestinataireParExpediteur( Long id1,Long id2);


	
	}


