package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Message;


public interface MessageRepository extends CrudRepository<Message, Long>{
	public List<Message> findByUserId(Long id);
	public List<Message> findByForumId(Long id);
	public List<Message> findByForumSujet(String sujet);

}
