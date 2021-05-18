package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.HistoriqueLocationSalle;
import fr.solutec.repository.HistoriqueLocationSalleRepository;

@RestController @CrossOrigin("*")
public class HistoriqueLocationSalleRest {

	@Autowired
	HistoriqueLocationSalleRepository historRepo;
	
	@GetMapping("salle/historique")
	public Iterable<HistoriqueLocationSalle> getAllHistorique(){
		return historRepo.findAll();
	}
	
	@GetMapping("salle/historique/id")
	public Optional<HistoriqueLocationSalle> getHistorById(@RequestBody Long id){
		return historRepo.findById(id);
	}
}
