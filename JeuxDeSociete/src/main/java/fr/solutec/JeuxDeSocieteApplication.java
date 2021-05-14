package fr.solutec;

import java.sql.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Categorie;
import fr.solutec.entities.Jeu;
import fr.solutec.entities.Marque;
import fr.solutec.entities.User;
import fr.solutec.repository.CategorieRepository;
import fr.solutec.repository.JeuRepository;
import fr.solutec.repository.MarqueRepository;
import fr.solutec.repository.UserRepository;

@SpringBootApplication
public class JeuxDeSocieteApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CategorieRepository categorieRepo;
	
	@Autowired
	MarqueRepository marqueRepo;
	
	@Autowired
	JeuRepository jeuRepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(JeuxDeSocieteApplication.class, args);
		
		
		System.out.println("Fin du programme");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test");
		User asterix = new User(null, "asterix", "azerty", "asterix.legaulois@gmail.com", "06.65.83.92.01");
		User obelix = new User(null, "obelix", "sanglier","obelix.lebg@outlook.com", "07.23.54.74.36");
		User panoramix = new User(null, "panoramix", "potion","pano.ledruide@orange.fr", "01.35.28.75.64");
		userRepo.save(asterix);
		userRepo.save(obelix);
		userRepo.save(panoramix);
		
		Categorie c1= new Categorie(null, "Plateau");
		Categorie c2 = new Categorie(null, "Cartes");
		Stream.of(c1,c2).forEach(c -> categorieRepo.save(c));
		
		Marque m1 = new Marque(null, "REPOS Production");
		Marque m2 = new Marque(null, "DUCALE");
		Stream.of(m1,m2).forEach(m -> marqueRepo.save(m));
		
		Jeu j1 = new Jeu(null, "7 Wonders", 3, 7, 10, "Difficile", null, "Un jeu où l'objectif est d'accumuler des points par divers moyens en un nombre de tours restraint.", "Je sais plus du tout dsl", c1, m1);
		Jeu j2 = new Jeu(null, "Tarot", 4, 5, 10, "Difficile", null, "2 camps s'affrontent pour remporter un maximum de points dans un jeu par manches.", "C'est compliqué ...", c2, m2);
		Stream.of(j1,j2).forEach(j -> jeuRepo.save(j));
	}

}
