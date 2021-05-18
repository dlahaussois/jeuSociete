package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Avis;
import fr.solutec.entities.Joueur;
import fr.solutec.entities.User;
import fr.solutec.repository.AvisRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class AvisRest {
	
	@Autowired
	AvisRepository avisRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping("avis")
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
	
	@PostMapping("avis")
	public Avis saveAvis(@RequestBody Avis a) {
		return avisRepo.save(a);
	}

	//Un user poste un avis
	@PostMapping("avis/post") 
	public Avis ecrireAvis(@RequestBody Avis a ) {
		Avis avis= new Avis();
		return avis= avisRepo.save(a);
	}
	
	
	
}
