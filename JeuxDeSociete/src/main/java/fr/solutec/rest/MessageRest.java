package fr.solutec.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Forum;
import fr.solutec.entities.Message;
import fr.solutec.entities.User;
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
		//écrire un message destiné à un sujet du forum en particulier
		@PostMapping("/message/{id}")
		public Message save(@RequestBody Message m, @PathVariable Forum id) {
			m.setForum(id);
			return messageRepo.save(m);
		}
		
		
		//écrire un message destiné à être une réponse d'un message dans un forum
		@PostMapping("/message/reponse/{id}")
		public Message save(@RequestBody Message m, @PathVariable Message id) {
			m.setMessage(id);
			return messageRepo.save(m);
		}
		
		
		/*@PostMapping("/reponse/message/{id}")
		public Message save(@RequestBody Message m, @PathVariable Long id) {
			Message m1 = new Message();
			m1.setId(id);
			m1.setReponse(m.getContenu());
			return messageRepo.save(m);
		}*/
		
		/*@PutMapping("/message")
		public Message modifMessage(@RequestBody Message m, @PathVariable String reponse) {
			m.setReponse(reponse);
			return messageRepo.save(m);
		}*/
		
		
		//écrire un message privé destiné à un utilisateur en particulier
				@PostMapping("/message/user/{id}")
				public Message save(@RequestBody Message m, @PathVariable User id) {
					m.setDestinataire(id);
					return messageRepo.save(m);
				}
		
		//obtenir tous les messages publics
		@GetMapping("/messages")
		public Iterable<Message> getAllPublic(){
			return messageRepo.findByPriveeIsFalse();
		}
		
		//obtenir message par id
		@GetMapping("message/{id}")
		public Optional<Message> getMessageById(@PathVariable Long id){
			return messageRepo.findById(id);
		}
		
		//obtenir tous les messages privés
		@GetMapping("/messages/prives")
		public Iterable<Message> getAllPrivee(){
		return messageRepo.findByPriveeIsTrue();
		}
		
		//obtenir les messages publics d'un expéditeur en particulier
		@GetMapping("messages/expediteur")
		public Optional<Iterable<Message>> getByIdExpediteur(@RequestBody Long id){  
		return messageRepo.trouverPublicByExpediteurId(id);
		}
		//obtenir les messages privés d'un expéditeur en particulier
		@GetMapping("messages/prives/expediteur")
		public Optional<Iterable<Message>> getByIdExpediteurPrive(@RequestBody Long id){  
		return messageRepo.trouverPriveByExpediteurId(id);
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
		@GetMapping("messages/forum")
		public List<Message> getMessageByIdForum(@RequestBody Long id){
			
			return messageRepo.findByForumId(id);
			}
	 //avoir tous les messages d'un forum par sujet
		@GetMapping("messages/{sujet}")
		public List<Message> getMessageByForumSujet(@PathVariable String sujet){
			
			return messageRepo.findByForumSujet(sujet);
			}
		
	@GetMapping("/messagerie/{id}")
	public Optional<Iterable<Message>> getMessagerieByUserId(@PathVariable Long id){
		return messageRepo.getMessagerieByUserId(id);
	}
}
