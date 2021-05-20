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
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.JoueurRepository;
import fr.solutec.repository.UserRepository;
import fr.solutec.repository.VendeurRepository;



@RestController @CrossOrigin("*")
public class UserRest {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	VendeurRepository vendeurRepo;
	
	@Autowired
	JoueurRepository joueurRepo;
	
	@GetMapping("user")
	public Iterable<User> getAllUser(){
		return userRepo.findAll();
	}
	
	@PostMapping("connect")
	public Optional<User> connexion(@RequestBody User u){
		return userRepo.connect(u.getLogin(), u.getPassword());
	}
	
	
	@GetMapping("user/id/{id}")
	public Optional<User> getUserById(@PathVariable Long id){
		return userRepo.findById(id);
	}
	
	@PostMapping("user")
	public User addUser(@RequestBody User u){
		return userRepo.save(u);
	}
	
	
	@GetMapping("user/login/{login}")
	public Optional<User> getUserByLogin(@PathVariable String login){
		return userRepo.findByLogin(login);
	}
	
	@PutMapping("user/bloquer")
	public  User bloquerUser(@RequestBody User u){
		u.setActivity(false);
		return userRepo.save(u);
	}
	
	@PostMapping("user/recherche")
	public  Optional<User> rechercheVendeurByLogin(@RequestBody User u){
		return userRepo.findByLogin(u.getLogin() );
	}
	
	@DeleteMapping("user/supprimer")
	public boolean suppPerson(@RequestBody Long id) {
		if (userRepo.findById(id).isPresent()) {
			System.out.println("dans if ");
			Optional< Admin  > a = adminRepo.findByUserId(id);
			if (a.isPresent()) {
				adminRepo.deleteById( a.get().getId() ) ;
				System.out.println("supp A ");
			}
			
			Optional< Joueur  > j = joueurRepo.findByUserId(id);
			if (j.isPresent()) {
				joueurRepo.deleteById( j.get().getId() ) ;
				System.out.println("supp J ");
			}
			Optional< Vendeur  > v = vendeurRepo.findByUserId(id);
			if (v.isPresent()) {
				vendeurRepo.deleteById( v.get().getId() ) ;
				System.out.println("supp V ");
			}
			System.out.println("supp U ");
			userRepo.deleteById(id);
			
			
			return true;
		}
		else {
			return false;
		}
				
			
	}
}
