package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.HistoriqueLocationSalle;
import fr.solutec.entities.Salle;
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
	
	@PutMapping("salle/historique/id")
	public HistoriqueLocationSalle validate(@RequestBody HistoriqueLocationSalle h){
		h.setLocationValidee(true);
		return historRepo.save(h);
	}
	//il me faut le résultat en Iterable<>
	
	@PostMapping("salle/historique")
	public HistoriqueLocationSalle addHistorique(@RequestBody HistoriqueLocationSalle h) {
		return historRepo.save(h);
	}
}
