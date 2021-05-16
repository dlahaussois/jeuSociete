package fr.solutec.rest;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Jeu;

import fr.solutec.repository.JeuRepository;


@RestController @CrossOrigin
public class JeuRest {

	@Autowired
	JeuRepository jeuRepo;
	
	@GetMapping("/jeu/list")
	public Iterable<Jeu> getAllJeu(){
		return jeuRepo.findAll();
	}
	
	@GetMapping("/jeu/{id}")
	public Optional<Jeu> getJeuByIdUrl(@PathVariable Long id){
		return jeuRepo.findById(id);
	}
	
	@GetMapping("/jeu/findById")
	public Optional<Jeu> getJeuByIdBody(@RequestBody Long id){
		return jeuRepo.findById(id);
	}
	
	@GetMapping("/jeu/findByNom")
	public Optional<Jeu> getJeuByNom(@RequestBody Jeu jeu){
		return jeuRepo.findByNom(jeu.getNom());
	}
	
	@GetMapping("/jeu/findByNomLike")
	public Optional<Iterable<Jeu>> getJeuByNomLike(@RequestBody Jeu jeu){
		return jeuRepo.getByNom(jeu.getNom());
	}
	
	@PostMapping("/jeu/save")
	public Jeu saveJeu(@RequestBody Jeu jeu) {
		return jeuRepo.save(jeu);
	}
	
}
