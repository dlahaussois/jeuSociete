package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Categorie;
import fr.solutec.repository.CategorieRepository;
import fr.solutec.repository.HistoriqueJeuLocationRepository;


@RestController @CrossOrigin("*")
public class HistoriqueJeuLocationRest {
	@Autowired
	HistoriqueJeuLocationRepository histojeulocationRepo;
}
