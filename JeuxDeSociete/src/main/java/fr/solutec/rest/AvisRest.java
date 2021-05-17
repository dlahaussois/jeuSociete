package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Avis;
import fr.solutec.repository.AvisRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class AvisRest {
	
	@Autowired
	AvisRepository avisRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping("avis/list")
	public Iterable<Avis> getAllAvis(){
		return avisRepo.findAll();
	}
	
	@GetMapping("avis/list/jeu/{id}")
	public List<Avis> getAllAvisbyJeuId(@PathVariable Long id){
		return avisRepo.findByJeuId(id);
		
	}
	
	@GetMapping("avis/list/user/{id}")
	public List<Avis> getAllAvisbyUserId(@PathVariable Long id){
		return avisRepo.findByUserId(id);
		
	}
	
	
	
	
}
