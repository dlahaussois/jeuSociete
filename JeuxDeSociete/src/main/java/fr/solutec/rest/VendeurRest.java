package fr.solutec.rest;

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

import fr.solutec.entities.Admin;
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
	

	@PutMapping("vendeur/modifier")
	public boolean modifierVendeur( @RequestBody User a) {
		userRepo.save(a);
		System.out.println("sa");
		System.out.println(a);
		return true;
	}

	
	@GetMapping("vendeur/id/{id}")
	public Optional<Vendeur> getVendeurById(@PathVariable Long id){
		return vendeurRepo.findById(id);
	}
	
	@GetMapping("vendeur/login/{login}")
	public Optional<Vendeur> getVendeurByLogin(@PathVariable String login){
		return vendeurRepo.findByUserLogin(login);
	}
	
	
	@PostMapping("vendeur/recherche")
	public  Optional<Vendeur> rechercheVendeurByLogin(@RequestBody User v){
		return vendeurRepo.findByUserLogin(v.getLogin() );
	}

	@PutMapping("vendeur/bloquer")
	public  Vendeur bloquerVendeur(@RequestBody Vendeur v){
		
		Vendeur ve = new Vendeur();
		
		boolean a = v.getUser().getActivity();
		
		if (a == true ) {
			v.getUser().setActivity(false);
			
		} else {
			v.getUser().setActivity(true);
			
		}
		System.out.println("v" + v);
		
		userRepo.save(v.getUser());
		ve =  vendeurRepo.save(v);
		
		return ve;
	}
	
	@GetMapping("vendeur/type/{login}")
	public int isVendeur(@PathVariable String login){
		
		Optional<Vendeur> v = vendeurRepo.isVendeur(login);
		
		if (v.isPresent() ) {
			return 2;
			} else {
					return 0;
			}
	}

}
