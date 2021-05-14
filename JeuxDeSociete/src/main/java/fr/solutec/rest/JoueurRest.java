package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import fr.solutec.entities.Joueur;

import fr.solutec.repository.JoueurRepository;

@RestController @CrossOrigin("*")
public class JoueurRest {

	@Autowired
	JoueurRepository joueurRepo;
	

	@PostMapping("joueur/save")
	public Joueur creerJoueur(@RequestBody Joueur j) {
		return joueurRepo.save(j);
		
	}
	
	@GetMapping("joueur/list")
	public Iterable<Joueur> getAllJoueur(){
		return joueurRepo.findAll();
	}
	
	
}
