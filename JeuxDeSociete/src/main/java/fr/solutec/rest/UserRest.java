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

import fr.solutec.entities.User;
import fr.solutec.entities.Vendeur;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class UserRest {

	@Autowired
	UserRepository userRepo;
	
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
	
}
