package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Forum;

import fr.solutec.repository.ForumRepository;


@RestController 
@CrossOrigin("*")
public class ForumRest {
	@Autowired //notre personne repository herite de crud repository
	private ForumRepository forumRepo;
	
	//obtenir tous les sujets du forum
	@GetMapping("/forum/sujets")
	public Iterable<Forum> getAllForum(){
	return forumRepo.findAll();
	}
}

