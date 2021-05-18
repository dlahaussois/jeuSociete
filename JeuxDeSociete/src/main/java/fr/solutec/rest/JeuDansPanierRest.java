package fr.solutec.rest;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.JeuDansPanier;
import fr.solutec.entities.User;
import fr.solutec.repository.JeuDansPanierRepository;

@RestController 
@CrossOrigin("*")
public class JeuDansPanierRest {
	@Autowired
	JeuDansPanierRepository jeupanierRepo;
	
	@GetMapping("/paniers")
	public Iterable<JeuDansPanier> getAllPaniers(){
		return jeupanierRepo.findAll();
	}
	
	@GetMapping("/panier/user")
	public Optional<Iterable<JeuDansPanier>> getPanierUser(@RequestBody User u){
		return jeupanierRepo.getByUserId(u.getId());
	}
	@GetMapping("/panier/user/{id}")
	public Optional<Iterable<JeuDansPanier>> getPanierUser(@PathVariable Long id){
		return jeupanierRepo.getByUserId(id);
	}
}
