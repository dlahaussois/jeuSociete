package fr.solutec.rest;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.Jeu;
import fr.solutec.entities.JeuAchat;
import fr.solutec.repository.JeuAchatRepository;
import fr.solutec.repository.JeuLocationRepository;
import fr.solutec.repository.JeuRepository;


@RestController @CrossOrigin
public class JeuRest {

	@Autowired
	JeuRepository jeuRepo;
	
	@Autowired
	JeuAchatRepository jaRepo;
	
	@Autowired
	JeuLocationRepository jlRepo;
	
	@GetMapping("/jeu/list")
	public Iterable<Jeu> getAllJeu(){
		return jeuRepo.findAll();
	}
	
	@GetMapping("/jeu/{id}")
	public Optional<Jeu> getJeuByIdUrl(@PathVariable Long id){
		return jeuRepo.findById(id);
	}
	
	@GetMapping("/jeu/findById")
	public Optional<Jeu> getJeuByIdBody(@RequestBody Long id){
		return jeuRepo.findById(id);
	}
	
	@GetMapping("/jeu/findByNom")
	public Optional<Jeu> getJeuByNom(@RequestBody Jeu jeu){
		return jeuRepo.findByNom(jeu.getNom());
	}
	
	@GetMapping("/jeu/findByNomLike")
	public Optional<Iterable<Jeu>> getJeuByNomLike(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByNom(jeu.getNom());
	}
	
	@GetMapping("/jeu/findByAgeMin")
	public Optional<Iterable<Jeu>> getJeuByAgeMin(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByAgeMin(jeu.getAgeMin());
	}
	
	@GetMapping("/jeu/findByMoreThanAgeMin")
	public Optional<Iterable<Jeu>> getJeuByMoreThanAgeMin(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByMoreThanAgeMin(jeu.getAgeMin());
	}
	
	@GetMapping("/jeu/findByLessThanAgeMin")
	public Optional<Iterable<Jeu>> getJeuByLessThanAgeMin(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByLessThanAgeMin(jeu.getAgeMin());
	}
	
	@GetMapping("/jeu/findByBetweenAgeMin")
	public Optional<Iterable<Jeu>> getJeuByBetweenAgeMin(@RequestBody int[] ageMins){
		return jeuRepo.getJeuByBetweenAgeMin(ageMins[0],ageMins[1]);
	}
	
	@GetMapping("/jeu/findByCategorie")
	public Optional<Iterable<Jeu>> getJeuByCategorie(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByCategorie(jeu.getCategorieDuJeu());
	}
	
	@GetMapping("/jeu/findByMarque")
	public Optional<Iterable<Jeu>> getJeuByMarque(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByMarque(jeu.getMarqueDuJeu());
	}
	
	@GetMapping("/jeu/listJeuAchat")
	public Iterable<JeuAchat> getAllJeuAchat(){
		return jaRepo.findAll();
	}
	
	@GetMapping("/jeu/findByPrixAchat")
	public Optional<Iterable<JeuAchat>> getJeuByPrixAchat(@RequestBody JeuAchat ja){
		return jaRepo.getJeuByPrixAchat(ja.getPrixAchat());
	}
	
	@GetMapping("/jeu/findByMoreThanPrixAchat")
	public Optional<Iterable<JeuAchat>> getJeuByMoreThanPrixAchat(@RequestBody JeuAchat ja){
		return jaRepo.getJeuByMoreThanPrixAchat(ja.getPrixAchat());
	}
	
	@GetMapping("/jeu/findByLessThanPrixAchat")
	public Optional<Iterable<JeuAchat>> getJeuByLessThanPrixAchat(@RequestBody JeuAchat ja){
		return jaRepo.getJeuByLessThanPrixAchat(ja.getPrixAchat());
	}
	
	@GetMapping("/jeu/findByBetweenPrixAchat")
	public Optional<Iterable<JeuAchat>> getJeuByBetweenPrixAchat(@RequestBody int[] PrixAchats){
		return jaRepo.getJeuByBetweenPrixAchat(PrixAchats[0],PrixAchats[1]);
	}
	
	@GetMapping("/jeu/findByTempsDeJeu")
	public Optional<Iterable<Jeu>> getJeuByTempsDeJeu(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByTempsDeJeu(jeu.getTempsDeJeu());
	}
	
	@GetMapping("/jeu/findByMoreThanTempsDeJeu")
	public Optional<Iterable<Jeu>> getJeuByMoreThanTempsDeJeu(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByMoreThanTempsDeJeu(jeu.getTempsDeJeu());
	}
	
	@GetMapping("/jeu/findByLessThanTempsDeJeu")
	public Optional<Iterable<Jeu>> getJeuByLessThanTempsDeJeu(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByLessThanTempsDeJeu(jeu.getTempsDeJeu());
	}
	
	@GetMapping("/jeu/findByBetweenTempsDeJeu") 
	public Optional<Iterable<Jeu>> getJeuByBetweenTempsDeJeu(@RequestBody int[] TempsDeJeux){
		return jeuRepo.getJeuByBetweenTempsDeJeu(TempsDeJeux[0],TempsDeJeux[1]);
	}
	
	@GetMapping("/jeu/findByDifficulte")
	public Optional<Iterable<Jeu>> getJeuByDifficulte(@RequestBody Jeu jeu){
		return jeuRepo.getByNiveauDifficulte(jeu.getNiveauDifficulte());
	}
	
	@PostMapping("/jeu/save")
	public Jeu saveJeu(@RequestBody Jeu jeu) {
		return jeuRepo.save(jeu);
	}
	
}
