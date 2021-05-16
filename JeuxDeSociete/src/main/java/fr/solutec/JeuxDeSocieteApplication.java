package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Categorie;
import fr.solutec.entities.Jeu;
import fr.solutec.entities.Joueur;
import fr.solutec.entities.Marque;
import fr.solutec.entities.User;
import fr.solutec.entities.Vendeur;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.CategorieRepository;
import fr.solutec.repository.JeuRepository;
import fr.solutec.repository.JoueurRepository;
import fr.solutec.repository.MarqueRepository;
import fr.solutec.repository.UserRepository;
import fr.solutec.repository.VendeurRepository;

import java.util.stream.Stream;

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
	
	
	@Autowired
	JoueurRepository joueurRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	VendeurRepository vendeurRepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(JeuxDeSocieteApplication.class, args);
		
		
		System.out.println("Fin du programme");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test");
		User asterix = new User(null, "asterix", "azerty", "asterix.legaulois@gmail.com", "06.65.83.92.01",true);
		User obelix = new User(null, "obelix", "sanglier","obelix.lebg@outlook.com", "07.23.54.74.36",true);
		User panoramix = new User(null, "panoramix", "potion","pano.ledruide@orange.fr", "01.35.28.75.64",true );
		User u4 = new User(null, "Admin", "Admin","admin@admin.fr", "01.35.28.75.64",true );
		User u5 = new User(null, "Vendeur", "Vendeur","vendeur@vendeur.fr", "01.35.28.75.64",true );
		
		Stream.of(asterix, obelix, panoramix, u4, u5).forEach(c -> userRepo.save(c));

		
		Categorie c1= new Categorie(null, "Plateau");
		Categorie c2 = new Categorie(null, "Cartes");
		Stream.of(c1,c2).forEach(c -> categorieRepo.save(c));
		
		Marque m1 = new Marque(null, "REPOS Production");
		Marque m2 = new Marque(null, "DUCALE");
		Stream.of(m1,m2).forEach(m -> marqueRepo.save(m));
		
		Joueur jo1 = new Joueur(null,asterix);
		Joueur jo2 = new Joueur(null,obelix);
		Stream.of(jo1,jo2).forEach(jo -> joueurRepo.save(jo));
		
		System.out.println(jo1);
		
		Jeu j1 = new Jeu(null, "7 Wonders", 3, 7, 10, "Difficile", 30, "Un jeu où l'objectif est d'accumuler des points par divers moyens en un nombre de tours restraint.", "Je sais plus du tout dsl",c1,m1);
		Jeu j2 = new Jeu(null, "Tarot", 4, 5, 10, "Difficile", 15, "2 camps s'affrontent pour remporter un maximum de points dans un jeu par manches.", "C'est compliqué ...",c2,m2);
		Stream.of(j1,j2).forEach(j -> jeuRepo.save(j));
		
		Admin a1 = new Admin(null,panoramix);
		Admin a2 = new Admin(null,u4);
		Stream.of(a1,a2).forEach(a -> adminRepo.save(a));
		
		Vendeur v1 = new Vendeur(null,u5);

		Stream.of(v1).forEach(a -> vendeurRepo.save(a));
		
	}

}
