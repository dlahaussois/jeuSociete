package fr.solutec.rest;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.Jeu;
import fr.solutec.entities.JeuAchat;
import fr.solutec.entities.JeuDansPanier;
import fr.solutec.entities.JeuLocation;
import fr.solutec.repository.JeuAchatRepository;
import fr.solutec.repository.JeuDansPanierRepository;
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
	
	@Autowired
	JeuDansPanierRepository jdpRepo;
	
	//---------------------------------------------------------------------------------------------------
	//Jeux
	
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
	
	//---------------------------------------------------------------------------------------------------
	//Jeux par Nom
	
	@GetMapping("/jeu/findByNom")
	public Optional<Jeu> getJeuByNom(@RequestBody Jeu jeu){
		return jeuRepo.findByNom(jeu.getNom());
	}
	
	@GetMapping("/jeu/findByNomLike")
	public Optional<Iterable<Jeu>> getJeuByNomLike(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByNom(jeu.getNom().toLowerCase());
	}
	
	//---------------------------------------------------------------------------------------------------
	//Jeux par agemin
	
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
	
	//---------------------------------------------------------------------------------------------------
	//Jeux par categorie et marque
	
	@GetMapping("/jeu/findByCategorie")
	public Optional<Iterable<Jeu>> getJeuByCategorie(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByCategorie(jeu.getCategorieDuJeu());
	}
	
	@GetMapping("/jeu/findByLibelleCategorie")
	public Optional<Iterable<Jeu>> getJeuByLibelleCategorie(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByLibelleCategorie(jeu.getCategorieDuJeu().getLibelle());
	}
	
	@GetMapping("/jeu/findByMarque")
	public Optional<Iterable<Jeu>> getJeuByMarque(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByMarque(jeu.getMarqueDuJeu());
	}
	
	@GetMapping("/jeu/findByLibelleMarque")
	public Optional<Iterable<Jeu>> getJeuByLibelleMarque(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByLibelleMarque(jeu.getMarqueDuJeu().getLibelle());
	}
	
	//---------------------------------------------------------------------------------------------------
	//Jeux achat et jeux location
	
	@GetMapping("/jeu/JeuAchat")
	public Optional<JeuAchat> getJeuAchatByIdJeu(@RequestBody Jeu jeu){
		return jaRepo.getJeuAchatByIdJeu(jeu.getId());
	}
	
	@GetMapping("/jeu/JeuLocation")
	public Optional<Iterable<JeuLocation>> getJeuLocationByIdJeu(@RequestBody Jeu jeu){
		return jlRepo.getJeuLocationByIdJeu(jeu.getId());
	}
	
	@GetMapping("/jeu/listJeuAchat")
	public Iterable<JeuAchat> getAllJeuAchat(){
		return jaRepo.findAll();
	}
	
	@GetMapping("/jeu/listJeuLocation")
	public Iterable<JeuLocation> getAllJeuLocation(){
		return jlRepo.findAll();
	}
	
	//---------------------------------------------------------------------------------------------------
	//Jeux par prix achat
	
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
	
	//---------------------------------------------------------------------------------------------------
	//Jeux par temps de jeu
	
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
	
	
	//---------------------------------------------------------------------------------------------------
	//Jeux par difficulte
	
	@GetMapping("/jeu/findByDifficulte")
	public Optional<Iterable<Jeu>> getJeuByDifficulte(@RequestBody Jeu jeu){
		return jeuRepo.getByNiveauDifficulte(jeu.getNiveauDifficulte());
	}
	
	
	
	//---------------------------------------------------------------------------------------------------
	//Jeux par nombre de joueurs min
	
	@GetMapping("/jeu/findByNombreJoueursMin")
	public Optional<Iterable<Jeu>> getJeuByNombreJoueursMin(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByNombreJoueursMin(jeu.getNombreJoueursMin());
	}
	
	@GetMapping("/jeu/findByMoreThanNombreJoueursMin")
	public Optional<Iterable<Jeu>> getJeuByMoreThanNombreJoueursMin(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByMoreThanNombreJoueursMin(jeu.getNombreJoueursMin());
	}
	
	@GetMapping("/jeu/findByLessThanNombreJoueursMin")
	public Optional<Iterable<Jeu>> getJeuByLessThanNombreJoueursMin(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByLessThanNombreJoueursMin(jeu.getNombreJoueursMin());
	}
	
	@GetMapping("/jeu/findByBetweenNombreJoueursMin") 
	public Optional<Iterable<Jeu>> getJeuByBetweenNombreJoueursMin(@RequestBody int[] NombresJoueursMin){
		return jeuRepo.getJeuByBetweenNombreJoueursMin(NombresJoueursMin[0],NombresJoueursMin[1]);
	}
	
	//---------------------------------------------------------------------------------------------------
	//Jeux par nombre de joueurs Max
	
	@GetMapping("/jeu/findByNombreJoueursMax")
	public Optional<Iterable<Jeu>> getJeuByNombreJoueursMax(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByNombreJoueursMax(jeu.getNombreJoueursMax());
	}
	
	@GetMapping("/jeu/findByMoreThanNombreJoueursMax")
	public Optional<Iterable<Jeu>> getJeuByMoreThanNombreJoueursMax(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByMoreThanNombreJoueursMax(jeu.getNombreJoueursMax());
	}
	
	@GetMapping("/jeu/findByLessThanNombreJoueursMax")
	public Optional<Iterable<Jeu>> getJeuByLessThanNombreJoueursMax(@RequestBody Jeu jeu){
		return jeuRepo.getJeuByLessThanNombreJoueursMax(jeu.getNombreJoueursMax());
	}
	
	@GetMapping("/jeu/findByBetweenNombreJoueursMax") 
	public Optional<Iterable<Jeu>> getJeuByBetweenNombreJoueursMax(@RequestBody int[] NombresJoueursMax){
		return jeuRepo.getJeuByBetweenNombreJoueursMax(NombresJoueursMax[0],NombresJoueursMax[1]);
	}
	
	
	//---------------------------------------------------------------------------------------------------
	//Ajouter/modifier/supprimer un jeu
	
	@PostMapping("/jeu/save")
	public Jeu saveJeu(@RequestBody Jeu jeu) {
		return jeuRepo.save(jeu);
	}
	
	@PutMapping("/jeu/modifier")
	public Jeu modifierJeu(@RequestBody Jeu jeu) {
		return jeuRepo.save(jeu);
	}
	
	@DeleteMapping("/jeu/delete")
	public boolean deleteJeu(@RequestBody Long id) {
		if (jeuRepo.findById(id).isPresent()) {
			jeuRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	//---------------------------------------------------------------------------------------------------
	//Ajouter/modifier/supprimer un jeu achat
	
	@PostMapping("/jeuAchat/save")
	public JeuAchat saveJeuAchat(@RequestBody JeuAchat jeuAchat) {
		return jaRepo.save(jeuAchat);
	}
	
	@PutMapping("/jeuAchat/modifier")
	public JeuAchat modifierJeuAchat(@RequestBody JeuAchat jeuAchat) {
		return jaRepo.save(jeuAchat);
	}
	
	@DeleteMapping("/jeuAchat/delete")
	public boolean deleteJeuAchat(@RequestBody Long id) {
		if (jaRepo.findById(id).isPresent()) {
			Optional<Iterable<JeuDansPanier>> listjdp = jdpRepo.getByJeuAchatId(id);
			if(listjdp.isPresent()) {
				for(JeuDansPanier jdp : listjdp.get()) {
					jdpRepo.deleteById(jdp.getId());
				}
			}
			jaRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	//---------------------------------------------------------------------------------------------------
	//Ajouter/modifier/supprimer un jeu location
	
	@PostMapping("/jeuLocation/save")
	public JeuLocation saveJeuLocation(@RequestBody JeuLocation jeuLocation) {
		return jlRepo.save(jeuLocation);
	}
	
	@PutMapping("/jeuLocation/modifier")
	public JeuLocation modifierJeuLocation(@RequestBody JeuLocation jeuLocation) {
		return jlRepo.save(jeuLocation);
	}
	
	@DeleteMapping("/jeuLocation/delete")
	public boolean deleteJeuLocation(@RequestBody Long id) {
		if (jlRepo.findById(id).isPresent()) {
			jlRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}
