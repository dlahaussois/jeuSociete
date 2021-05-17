package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import fr.solutec.entities.Joueur;
import fr.solutec.entities.User;
import fr.solutec.entities.Vendeur;
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
		Joueur j = new Joueur(null, false, u1);
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
	

	@PostMapping("joueur/recherche")
	public  Iterable<Joueur> rechercheVendeurByLogin(@RequestBody User j){
		return joueurRepo.findByUserLogin(j.getLogin());
	}

	@PutMapping("joueur/adherer")
	public  void adhererJoueur(@RequestBody Joueur j){
		
		boolean a;
		a = j.isCotisation();
				
		System.out.println(j);
		
		
		if (a == true ) {
			j.setCotisation(false);
			
		} else {
			j.setCotisation(true);
			
		}
		System.out.println(j);
		
		joueurRepo.save(j);
	}
	
	
	
}
