package fr.solutec.rest;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Avis;
import fr.solutec.entities.Joueur;
import fr.solutec.entities.User;
import fr.solutec.repository.AvisRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class AvisRest {
	
	@Autowired
	AvisRepository avisRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping("avis")
	public Iterable<Avis> getAllAvis(){
		return avisRepo.findAll();
	}
	
	@GetMapping("avis/jeu/{id}")
	public List<Avis> getAllAvisbyJeuId(@PathVariable Long id){
		return avisRepo.findByJeuId(id);
		
	}
	
	@GetMapping("avis/moyenne/{id}")
	public double getMoyennebyJeuId(@PathVariable Long id) {
		List<Avis> avis = getAllAvisbyJeuId(id);
		double compteur = 0;
		double moyenne = 0;
		for (Avis a : avis) {
			moyenne = moyenne + a.getNote();
			compteur=compteur+1;
		}
		moyenne = moyenne/compteur;
		//permet d'arrondir à 1 chiffre après la virgule
        double scale = Math.pow(10, 1);
        double moyenneR = Math.round(moyenne*scale)/scale;
        return moyenneR;
		}
	
	
	
	
	
	@GetMapping("avis/user/{id}")
	public List<Avis> getAllAvisbyUserId(@PathVariable Long id){
		return avisRepo.findByUserId(id);
		
	}
	
	@PostMapping("avis")
	public Avis saveAvis(@RequestBody Avis a) {
		return avisRepo.save(a);
	}

	//Un user poste un avis
	@PostMapping("avis/post") 
	public Avis ecrireAvis(@RequestBody Avis a ) {
		Avis avis= new Avis();
		return avis= avisRepo.save(a);
	}
	
	@DeleteMapping("avis/delete")
	public void effacerAvis(@RequestBody Avis a) {
		avisRepo.delete(a);
	}
	
	
}
