package fr.solutec.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Forum;
import fr.solutec.entities.Message;

import fr.solutec.repository.MessageRepository;

@RestController 
@CrossOrigin("*")
public class MessageRest {
	@Autowired 
	private MessageRepository messageRepo;
	
	//écrire un message dans le forum/à un user
		@PostMapping("/message")
		public Message save(@RequestBody Message m) {
			return messageRepo.save(m);
		}
		//obtenir tous les messages publics
		@GetMapping("/messages")
		public Iterable<Message> getAllPublic(){
			return messageRepo.findByPriveeIsFalse();
		}
		
		
		//obtenir les messages publics d'un expéditeur en particulier
		@GetMapping("messages/expediteur")
		public Optional<Iterable<Message>> getByIdExpediteur(@RequestBody Long id){  
		return messageRepo.trouverPublicByExpediteurId(id);
		}
		
		//suppression d'un message
		@DeleteMapping("message/{id}")
		public boolean suppMessage(@PathVariable Long id) {
			Optional<Message> m = messageRepo.findById(id);
		    if (m.isPresent()) {
		    	messageRepo.delete(m.get());
		    	return true;
		    }
		    else {
		    	return false;
		    }
		}
		//avoir tous les messages d'un forum by id
		@GetMapping("forum/messages")
		public List<Message> getMessageByIdForum(@RequestBody Long id){
			
			return messageRepo.findByForumId(id);
			}
	 //avoir tous les messages d'un forum par sujet
		@GetMapping("sujet/messages")
		public List<Message> getMessageByForumSujet(@RequestBody Forum sujet){
			
			return messageRepo.findByForumSujet(sujet.getSujet());
			}
}
