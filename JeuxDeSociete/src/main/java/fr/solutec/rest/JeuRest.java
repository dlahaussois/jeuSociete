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

import fr.solutec.entities.Jeu;
import fr.solutec.entities.User;
import fr.solutec.repository.JeuRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin
public class JeuRest {

	@Autowired
	JeuRepository jeuRepo;
	
	@GetMapping("jeu/list")
	public Iterable<Jeu> getAllJeu(){
		return jeuRepo.findAll();
	}
	
	@PostMapping("jeu/save")
	public Jeu saveJeu(@RequestBody Jeu jeu) {
		return jeuRepo.save(jeu);
	}
	
}
