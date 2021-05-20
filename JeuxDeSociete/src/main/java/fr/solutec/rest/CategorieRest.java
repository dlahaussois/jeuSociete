package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Categorie;
import fr.solutec.repository.CategorieRepository;


@RestController @CrossOrigin
public class CategorieRest {
	@Autowired
	CategorieRepository categorieRepo;
	
	@GetMapping("/categories")
	public Iterable<Categorie> getAllCategorie(){
		return categorieRepo.findAll();
	}
	
	@GetMapping("/categoriesOrdered")
	public Iterable<Categorie> getAllCategorieOrderByAlphabetical(){
		return categorieRepo.getCategorieByAlphabetical();
	}
}
