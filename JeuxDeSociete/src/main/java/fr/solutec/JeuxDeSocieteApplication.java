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
		Categorie c3 = new Categorie(null, "Histoire");
		Stream.of(c1,c2,c3).forEach(c -> categorieRepo.save(c));
		
		Marque m1 = new Marque(null, "REPOS Production");
		Marque m2 = new Marque(null, "DUCALE");
		Marque m3 = new Marque(null, "Devil Pig Games");
		Stream.of(m1,m2,m3).forEach(m -> marqueRepo.save(m));
		
		Joueur jo1 = new Joueur(null,asterix);
		Joueur jo2 = new Joueur(null,obelix);
		Stream.of(jo1,jo2).forEach(jo -> joueurRepo.save(jo));
		
		System.out.println(jo1);
		
		Jeu j1 = new Jeu(null, "7 Wonders Nouvelle édition", 3, 7, 10, "Difficile", 30, "7 Wonders, un jeu mythique\r\nDans 7 Wonders, vous êtes à la tête de l'une des sept grandes cités du monde antique. Votre but est de faire prospérer votre ville pour la rendre plus influente que celles de vos adversaires. Le futur des cités légendaires comme Babylone, Éphèse ou encore Rhodes dépend de vos talents de gestionnaire. Pour inscrire votre cité dans l'Histoire, vous devrez agir dans différents secteurs de développement. Exploitez les ressources naturelles de vos terres, participez aux progrès scientifiques, développez vos relations commerciales et affirmez votre suprématie militaire. Laissez votre empreinte dans l'histoire des civilisations en bâtissant une merveille monumentale.\r\n\r\n7 Wonders, un jeu de draft à travers 3 âges\r\nUne partie se déroule à travers 3 âges successifs comportant chacun 6 tours de jeu. Chaque époque se joue de manière identique et repose sur un système de draft. Chaque joueur choisit une carte de sa main, la joue et passe les cartes restantes au joueur suivant. Ce principe de jeu permet aux différents paquets de cartes de tourner entre les joueurs qui ont donc 6 cartes pour développer au mieux leur stratégie. À chaque tour, les participants ont 3 actions possibles : construire leur cité, développer leur merveille ou gagner de l'argent.\r\n\r\n7 Wonders, un jeu stratégique\r\nPour régner en maître, les joueurs devront établir une stratégie et composer avec leurs cartes pour dérouler leur plan d'actions sans encombre. Le jeu leur offre aussi la possibilité d'interagir avec les autres joueurs en bénéficiant de certains avantages tirés des cartes jouées. À la fin du 3ème âge, les joueurs devront compter leurs points de victoire. Le score final dépendra des bâtiments construits (commerciaux, civils et scientifiques), du stade de développement de leur merveille, des victoires militaires et des fortunes engrangées. 7 Wonders est un jeu stratégique où les joueurs ne doivent oublier aucun aspect du jeu pour triompher. La cité doit prospérer sur le plan civil, scientifique, commercial et militaire. Autrement dit, leur cité devra être belle, riche et puissante. Le joueur avec le score le plus élevé est déclaré vainqueur.\r\n\r\nLes 7 valeurs ajoutées de la nouvelle édition de 7 Wonders\r\nune refonte graphique du jeu. Sorti en 2010 et accumulant plus de 30 prix internationaux, 7 Wonders méritait de se refaire une beauté ! La couverture, le design des cartes, les merveilles, le thermoformage: tout y est passé !\r\nLa rédaction des règles a entièrement été revue pour les rendre plus simples d’accès aux débutants. Fini les longues pages à lire, on passe maintenant à un livret de règles de 8 pages beaucoup plus facile à appréhender et à comprendre !\r\nL’aide de jeu aussi a été totalement repensée.\r\nGrâce à une meilleure ergonomie des cartes, le joueur gagne de la place à table. Le nouvel agencement des cartes permet une lecture facile des informations. Les cartes guildes, dispersées dans les différentes extensions de 7 Wonders, ont été rassemblées et ajoutées au nouveau jeu de base.\r\nLa taille des merveilles a augmenté permettant une meilleure immersion du jeu avec le thème principal de 7 Wonders, ses merveilles ! Le format de la boîte du jeu de base et de ses extensions sera aussi plus grand, adoptant une taille de boîte standard. Toujours pour respecter au mieux l’immersion dans le jeu, les faces A et B des merveilles ont été repensées et sont remplacées par une face jour et une face nuit. Découvrez les merveilles sous leur aspect diurne et nocturne!\r\n7 Wonders s’inspire aussi du chaînage de 7 Wonders Duel, plus ergonomique et plus intuitif.\r\nGrâce aux symboles intégrés discrètement dans le contenu du jeu, 7 Wonders et ses extensions sont maintenant adaptés aux joueurs daltoniens.", "Je sais plus du tout dsl","https://cdn2.philibertnet.com/478484-thickbox_default/7-wonders-nouvelle-edition.jpg",c1,m1);
		Jeu j2 = new Jeu(null, "Tarot", 4, 5, 10, "Difficile", 15, "2 camps s'affrontent pour remporter un maximum de points dans un jeu par manches.", "C'est compliqué ...","https://cdn3.philibertnet.com/494314-thickbox_default/jeu-de-tarot-78-cartes-boite-plastique.jpg",c2,m2);
		Jeu j3 = new Jeu(null, "Heroes of Stalingrad", 2, 2, 14, "Moyenne",45 , "Heroes of Stalingrad est le nouveau Wargame signé Devil Pig Games. Plongez grâce aux mécaniques dynamiques et stratégiques du Heroes System : Tactical Scale, dans l’une des batailles les plus décisives de la Seconde Guerre mondiale. A deux durant des parties de 30 minutes et plus, vous incarnerez les plus grands héros de ce conflit dans le pur style des films de guerre.\r\n\r\nQue vous connaissiez ou non nos autres jeux utilisant ces mécaniques, Heroes of Stalingrad est la boîte de base idéale pour découvrir le Heroes System : Tactical Scale au rythme des chants patriotiques des commissaires politiques bravant MG34 et DP28 !", "Je sais connais pas les règles dsl", "https://cdn2.philibertnet.com/466792-thickbox_default/heroes-of-stalingrad.jpg", c3, m3);
		Stream.of(j1,j2,j3).forEach(j -> jeuRepo.save(j));
		
		Admin a1 = new Admin(null,panoramix);
		Admin a2 = new Admin(null,u4);
		Stream.of(a1,a2).forEach(a -> adminRepo.save(a));
		
		Vendeur v1 = new Vendeur(null,u5);

		Stream.of(v1).forEach(a -> vendeurRepo.save(a));
		
	}

}
