package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.HistoriqueJeuAchat;
import fr.solutec.entities.HistoriqueJeuLocation;
import fr.solutec.repository.CategorieRepository;
import fr.solutec.repository.HistoriqueJeuAchatRepository;
import fr.solutec.repository.HistoriqueJeuLocationRepository;


@RestController @CrossOrigin("*")
public class HistoriqueJeuAchatRest {
	@Autowired
	HistoriqueJeuAchatRepository histojeuachatRepo;
	
	@GetMapping("/histoAchat")
	public Iterable<HistoriqueJeuAchat> getHistoAchat(){
		return histojeuachatRepo.findAll();
	}
	
	@GetMapping("/histoAchat/user/{id}")
	public Optional<Iterable<HistoriqueJeuAchat>> getJeuAchatByUser(@PathVariable Long id){
		return histojeuachatRepo.getByUserId(id);
	}
}
