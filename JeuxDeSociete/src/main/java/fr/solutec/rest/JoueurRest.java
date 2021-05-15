package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import fr.solutec.entities.Joueur;
import fr.solutec.entities.User;
import fr.solutec.repository.JoueurRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class JoueurRest {

	@Autowired
	JoueurRepository joueurRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
//Creation joueur depuis infos user
	@PostMapping("joueur/save")
	public Joueur addJoueur(@RequestBody User u) {
		User u1 = userRepo.save(u);
		Joueur j = new Joueur(null, u1);
		return joueurRepo.save(j);
		
	}
	
	@GetMapping("joueur/list")
	public Iterable<Joueur> getAllJoueur(){
		return joueurRepo.findAll();
	}
	

	

	
	@GetMapping("joueur/{id}")
	public Optional<User> getJoueurById(@PathVariable Long id){
		return userRepo.findById(id);
	}
	

	
	
}
