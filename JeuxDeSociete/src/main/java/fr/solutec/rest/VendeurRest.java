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
import fr.solutec.repository.VendeurRepository;

@RestController @CrossOrigin("*") 
public class VendeurRest {

	@Autowired
	VendeurRepository vendeurRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	//Creation Vendeur depuis infos user
	@PostMapping("vendeur/save")
	public Vendeur addVendeur(@RequestBody User u) {
		User u1 = userRepo.save(u);
		Vendeur v = new Vendeur(null, u1);
		return vendeurRepo.save(v);
		
	}
	
	
	@GetMapping("vendeur/list")
	public Iterable<Vendeur> getAllVendeur(){
		return vendeurRepo.findAll();
	}
	

	

	
	@GetMapping("vendeur/id/{id}")
	public Optional<Vendeur> getVendeurById(@PathVariable Long id){
		return vendeurRepo.findById(id);
	}
	
	@GetMapping("vendeur/login/{login}")
	public Iterable<Vendeur> getVendeurByLogin(@PathVariable String login){
		return vendeurRepo.findByUserLogin(login);
	}
	
	
	@PostMapping("vendeur/recherche")
	public  Iterable<Vendeur> rechercheVendeurByLogin(@RequestBody User v){
		return vendeurRepo.findByUserLogin(v.getLogin() );
	}

	@PutMapping("vendeur/bloquer")
	public  void bloquerVendeur(@RequestBody Vendeur v){
		
		System.out.println(v);
		boolean a = v.getUser().getActivity();
		
		if (a == true ) {
			v.getUser().setActivity(false);
			
		} else {
			v.getUser().setActivity(true);
			
		}
		System.out.println(v);
		
		userRepo.save(v.getUser());
		vendeurRepo.save(v);
	}
	
	
	
}
