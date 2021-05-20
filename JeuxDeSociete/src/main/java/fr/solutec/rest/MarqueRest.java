package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import fr.solutec.entities.Marque;

import fr.solutec.repository.MarqueRepository;

@RestController @CrossOrigin
public class MarqueRest {
	@Autowired
	MarqueRepository marqueRepo;
	
	@GetMapping("/marques")
	public Iterable<Marque> getAllMarque(){
		return marqueRepo.findAll();
	}
	
	@GetMapping("/marquesOrdered")
	public Iterable<Marque> getAllMarqueByAlphabetical(){
		return marqueRepo.getMarqueByAlphabetical();
	}
	
}
