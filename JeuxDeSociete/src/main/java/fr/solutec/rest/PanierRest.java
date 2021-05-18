package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.repository.PanierRepository;


@RestController 
@CrossOrigin("*")
public class PanierRest {
	@Autowired //notre personne repository herite de crud repository
	PanierRepository panierRepo;
	
	
	

}
