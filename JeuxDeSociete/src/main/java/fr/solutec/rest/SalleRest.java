package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Salle;

import fr.solutec.repository.SalleRepository;

@RestController @CrossOrigin("*") 
public class SalleRest {


	
	@Autowired
	SalleRepository salleRepo;
	
	
	
	@PostMapping("salle/save")
	public Salle addSalle(@RequestBody Salle s) {
		return salleRepo.save(s);
		
	}
	
	
	@GetMapping("salle/list")
	public Iterable<Salle> getAllSalle(){
		return salleRepo.findAll();
	}
	

	

	
	@GetMapping("salle/id/{id}")
	public Optional<Salle> getSalleById(@PathVariable Long id){
		return salleRepo.findById(id);
	}
	
	@GetMapping("salle/login/{login}")
	public Optional<Salle> getSalleByNom(@PathVariable String login){
		return salleRepo.findByNom(login);
	}
	
	


	
	
}
