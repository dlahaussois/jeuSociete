package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Niveau;
import fr.solutec.repository.NiveauRepository;

@RestController @CrossOrigin
public class NiveauRest {
	@Autowired
	NiveauRepository niveauRepo;
	
	@GetMapping("/niveaux")
	public Iterable<Niveau> getAllNiveau(){
		return niveauRepo.findAll();
	}
}
