package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.HistoriqueJeuLocation;
import fr.solutec.repository.CategorieRepository;
import fr.solutec.repository.HistoriqueJeuLocationRepository;


@RestController @CrossOrigin("*")
public class HistoriqueJeuLocationRest {
	@Autowired
	HistoriqueJeuLocationRepository histojeulocationRepo;
	
	@GetMapping("/histoLoc")
	public Iterable<HistoriqueJeuLocation> getHistoLoc(){
		return histojeulocationRepo.findAll();
	}
	
	@GetMapping("/histoLoc/user/{id}")
	public Optional<Iterable<HistoriqueJeuLocation>> getJeuLocByUser(@PathVariable Long id){
		return histojeulocationRepo.getByUserId(id);
	}
}
