package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Admin;
import fr.solutec.entities.Avis;
import fr.solutec.entities.Categorie;
import fr.solutec.entities.Forum;
import fr.solutec.entities.Jeu;
import fr.solutec.entities.JeuAchat;
import fr.solutec.entities.JeuDansPanier;
import fr.solutec.entities.JeuLocation;
import fr.solutec.entities.Joueur;
import fr.solutec.entities.Marque;
import fr.solutec.entities.Message;


import fr.solutec.entities.Salle;

import fr.solutec.entities.User;
import fr.solutec.entities.Vendeur;
import fr.solutec.repository.AdminRepository;
import fr.solutec.repository.AvisRepository;
import fr.solutec.repository.CategorieRepository;
import fr.solutec.repository.ForumRepository;
import fr.solutec.repository.JeuAchatRepository;
import fr.solutec.repository.JeuDansPanierRepository;
import fr.solutec.repository.JeuLocationRepository;
import fr.solutec.repository.JeuRepository;
import fr.solutec.repository.JoueurRepository;
import fr.solutec.repository.MarqueRepository;
import fr.solutec.repository.MessageRepository;


import fr.solutec.repository.SalleRepository;

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
	JeuAchatRepository jaRepo;
	
	@Autowired
	JeuLocationRepository jlRepo;
	
	@Autowired
	JoueurRepository joueurRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	VendeurRepository vendeurRepo;
	
	@Autowired
	AvisRepository avisRepo;
	
	@Autowired
	ForumRepository forumRepo;
	
	@Autowired
	MessageRepository messageRepo;
	
	@Autowired
	JeuDansPanierRepository jeudanspanierRepo;

	@Autowired
	SalleRepository salleRepo;

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
		Categorie c4 = new Categorie(null, "Puzzle");
		Stream.of(c1,c2,c3,c4).forEach(c -> categorieRepo.save(c));
		
		Marque m1 = new Marque(null, "REPOS Production");
		Marque m2 = new Marque(null, "France Cartes");
		Marque m3 = new Marque(null, "Devil Pig Games");
		Marque m4 = new Marque(null, "Heye");
		Marque m5 = new Marque(null, "Londji");
		Marque m6 = new Marque(null, "Hasbro Gaming");
		Marque m7 = new Marque(null, "Ravensburger");
		Stream.of(m1,m2,m3,m4,m5,m6,m7).forEach(m -> marqueRepo.save(m));
		


		Joueur jo1 = new Joueur(null,true,asterix);
		Joueur jo2 = new Joueur(null,false,obelix);

		Stream.of(jo1,jo2).forEach(jo -> joueurRepo.save(jo));
		
		System.out.println(jo1);
		
		Jeu j1 = new Jeu(null, "7 Wonders Nouvelle édition", 3, 7, 10, "Difficile", 30, "7 Wonders, un jeu mythique\r\nDans 7 Wonders, vous êtes à la tête de l'une des sept grandes cités du monde antique. Votre but est de faire prospérer votre ville pour la rendre plus influente que celles de vos adversaires. Le futur des cités légendaires comme Babylone, Éphèse ou encore Rhodes dépend de vos talents de gestionnaire. Pour inscrire votre cité dans l'Histoire, vous devrez agir dans différents secteurs de développement. Exploitez les ressources naturelles de vos terres, participez aux progrès scientifiques, développez vos relations commerciales et affirmez votre suprématie militaire. Laissez votre empreinte dans l'histoire des civilisations en bâtissant une merveille monumentale.\r\n\r\n7 Wonders, un jeu de draft à travers 3 âges\r\nUne partie se déroule à travers 3 âges successifs comportant chacun 6 tours de jeu. Chaque époque se joue de manière identique et repose sur un système de draft. Chaque joueur choisit une carte de sa main, la joue et passe les cartes restantes au joueur suivant. Ce principe de jeu permet aux différents paquets de cartes de tourner entre les joueurs qui ont donc 6 cartes pour développer au mieux leur stratégie. À chaque tour, les participants ont 3 actions possibles : construire leur cité, développer leur merveille ou gagner de l'argent.\r\n\r\n7 Wonders, un jeu stratégique\r\nPour régner en maître, les joueurs devront établir une stratégie et composer avec leurs cartes pour dérouler leur plan d'actions sans encombre. Le jeu leur offre aussi la possibilité d'interagir avec les autres joueurs en bénéficiant de certains avantages tirés des cartes jouées. À la fin du 3ème âge, les joueurs devront compter leurs points de victoire. Le score final dépendra des bâtiments construits (commerciaux, civils et scientifiques), du stade de développement de leur merveille, des victoires militaires et des fortunes engrangées. 7 Wonders est un jeu stratégique où les joueurs ne doivent oublier aucun aspect du jeu pour triompher. La cité doit prospérer sur le plan civil, scientifique, commercial et militaire. Autrement dit, leur cité devra être belle, riche et puissante. Le joueur avec le score le plus élevé est déclaré vainqueur.\r\n\r\nLes 7 valeurs ajoutées de la nouvelle édition de 7 Wonders\r\nune refonte graphique du jeu. Sorti en 2010 et accumulant plus de 30 prix internationaux, 7 Wonders méritait de se refaire une beauté ! La couverture, le design des cartes, les merveilles, le thermoformage: tout y est passé !\r\nLa rédaction des règles a entièrement été revue pour les rendre plus simples d’accès aux débutants. Fini les longues pages à lire, on passe maintenant à un livret de règles de 8 pages beaucoup plus facile à appréhender et à comprendre !\r\nL’aide de jeu aussi a été totalement repensée.\r\nGrâce à une meilleure ergonomie des cartes, le joueur gagne de la place à table. Le nouvel agencement des cartes permet une lecture facile des informations. Les cartes guildes, dispersées dans les différentes extensions de 7 Wonders, ont été rassemblées et ajoutées au nouveau jeu de base.\r\nLa taille des merveilles a augmenté permettant une meilleure immersion du jeu avec le thème principal de 7 Wonders, ses merveilles ! Le format de la boîte du jeu de base et de ses extensions sera aussi plus grand, adoptant une taille de boîte standard. Toujours pour respecter au mieux l’immersion dans le jeu, les faces A et B des merveilles ont été repensées et sont remplacées par une face jour et une face nuit. Découvrez les merveilles sous leur aspect diurne et nocturne!\r\n7 Wonders s’inspire aussi du chaînage de 7 Wonders Duel, plus ergonomique et plus intuitif.\r\nGrâce aux symboles intégrés discrètement dans le contenu du jeu, 7 Wonders et ses extensions sont maintenant adaptés aux joueurs daltoniens.", "Je sais plus du tout dsl","https://cdn2.philibertnet.com/478484-thickbox_default/7-wonders-nouvelle-edition.jpg",8.10,c1,m1);
		Jeu j2 = new Jeu(null, "Tarot de compétition", 4, 5, 10, "Difficile", 15, "Jeu de tarot traditionnel de 78 cartes, dos écossais, avec règles du jeu en français. Dimensions 6 x 11,5 cm. Convient pour les compétitions.", "C'est compliqué ...","https://www.lerepairedudragon.fr/78194-large_default/jeu-de-tarot-traditionnel.jpg",2.00,c2,m2);
		Jeu j3 = new Jeu(null, "Heroes of Stalingrad", 2, 2, 14, "Moyen",45 , "Heroes of Stalingrad est le nouveau Wargame signé Devil Pig Games. Plongez grâce aux mécaniques dynamiques et stratégiques du Heroes System : Tactical Scale, dans l’une des batailles les plus décisives de la Seconde Guerre mondiale. A deux durant des parties de 30 minutes et plus, vous incarnerez les plus grands héros de ce conflit dans le pur style des films de guerre.\r\n\r\nQue vous connaissiez ou non nos autres jeux utilisant ces mécaniques, Heroes of Stalingrad est la boîte de base idéale pour découvrir le Heroes System : Tactical Scale au rythme des chants patriotiques des commissaires politiques bravant MG34 et DP28 !", "Je sais connais pas les règles dsl", "https://cdn2.philibertnet.com/466792-thickbox_default/heroes-of-stalingrad.jpg",10.80, c3, m3);
		Jeu j4 = new Jeu(null, "Puzzle - Inner Mystic - 1000 Pièces", 1, 1, 10, "Difficile", 120, "Puzzle de 1000 pièces en carton de la marque HEYE.\r\nFormat : Paysage\r\nDimensions : 50x70 cm\r\nFabriqué avec du carton recyclé.\r\nSous le ciel grandiose rêve une petite créature mythique. Si vous regardez de plus près en faisant le puzzle, vous découvrirez l'attention incroyablement affectueuse qu'Andy Kehoe porte aux détails.", "Assemblez les pièces pour reproduire le motif.", "https://cdn1.philibertnet.com/503142-thickbox_default/puzzle-inner-mystic-1000-pieces.jpg",3.90, c4, m4);
		Jeu j5 = new Jeu(null, "Puzzle - Vincent Van Gogh - Nuit Etoilée - 1000 Pièces", 1, 1, 10, "Difficile", 120, "Puzzle classique de 1000 pièces\r\nFormat:Paysage\r\nDimensions :\r\n46 cm x 65 cm\r\nArtiste maudit et incompris, esprit sensible et torturé, Vincent Van Gogh (1853–1890) est devenu une légende. Réputé inclassable, il appartient pourtant à la mouvance postimpressionniste, tout comme son ami Paul Gauguin. Avec sa palette vive et sa touche exaltée, il apparaît aussi comme un précurseur du fauvisme et de l’expressionnisme tout en se rapprochant du symbolisme par sa conception mystique de l’art. Peintre infatigable mort à 37 ans, il a produit plus de 800 toiles. Associant réflexions sur la forme et sur la couleur, la démarche de Vincent Van Gogh incarne parfaitement le génie de l’art moderne.\r\nLa Nuit étoilée, 1889\r\n\r\n« Souvent, il me semble que la nuit est encore plus richement colorée que le jour », écrivit le peintre. Ce paysage nocturne fut réalisé depuis la chambre que Vincent Van Gogh occupait à l’asile de Saint-Rémy-de-Provence. Il se singularise par le traitement du ciel, qui occupe la majeure partie de la toile. Le mouvement tourbillonnant de l’air forme des vagues, et les étoiles étincellent comme autant de soleils. La touche est fragmentée, les couleurs sont pures. L’agitation du ciel contraste avec la tranquillité du village endormi. Vincent Van Gogh exprime ici sa vision mystique du monde, à la recherche d’une vérité invisible.", "Assemblez les pièces pour reproduire le motif.", "https://cdn2.philibertnet.com/502566-thickbox_default/puzzle-vincent-van-gogh-nuit-etoilee-1000-pieces.jpg",4.18, c4, m5);
		Jeu j6 = new Jeu(null, "Monopoly", 2, 6, 8, "Facile", 45, "Le jeu de société le plus célèbre du monde !\r\nOn ne présente plus le Monopoly. Édité pour la première fois en 1935, ce jeu de société incontournable, ayant pour thème central les transactions immobilières, s'est imposé au fil des décennies comme étant le plus gros succès du monde ludique. \r\n\r\nLe but du jeu est simple : les joueurs doivent acheter, vendre, construire et spéculer pour s'enrichir un maximum tout en forçant les autres à faire faillite. \r\nPour être déclaré gagnant, les joueurs devront acheter des propriétés afin de s'enrichir le plus possible. Plus ils posséderont de propriétés, plus ils auront d'argent.\r\n\r\nLe Monopoly est un jeu familial qui demande une bonne stratégie et une bonne gestion tout en intégrant une dimension de chance et de hasard. Cette version classique est adaptée à toute la famille et conviendra aussi bien aux adultes qu'aux enfants.\r\n\r\nChaque année, le Monopoly fait partie des jeux de société les plus vendus en France et dans le monde. Le jeu n'a cessé de se réinventer et se décline aujourd'hui en plusieurs versions et éditions (France, villes françaises, Nintendo, Fortnite, édition Tricheurs, etc.).", "Comment jouer au Monopoly ?\r\nUne partie de Monopoly se déroule en plusieurs tours de jeu où les joueurs jouent successivement. À son tour, le joueur lance les deux dés, avance son pion sur le parcours en fonction de la valeur obtenue, puis effectue une action d'après la nature de la case sur laquelle il est arrêté :\r\n\r\nLe Monoply se présente sous la forme d'un plateau de jeu composé de différentes cases sur lesquelles circulent les joueurs, représentés pour leur pion. Il existe plusieurs types de cases : \r\n\r\nLes cases Propriétés représentent des avenues, des places, des chemins de fer ou des services publiques. Il s'agit des cases que les joueurs pourront acquérir pour faire fortune.\r\nLes cases Récompenses correspondent à des emplacements qui apporteront un avantage aux joueurs. Il existe différentes cases Récompenses, comme la case Chance, la case Départ, la case Caisse de Communauté ou encore la case Parc Gratuit.\r\nLes cases Pénalités représentent les emplacements que les joueurs préféreront éviter comme la case Allez en prison, la case Prison, la Taxe de luxe ou encore la case Impôt sur le revenu.\r\nLa case Simple visite : celle-ci représente un emplacement neutre, c'est-à-dire qui n'a aucun effet sur les joueurs.\r\nUne partie de Monopoly peut durer entre 1h et 2h au maximum. Le jeu prend fin lorsqu'un joueur est le dernier à ne pas avoir fait faillite. Il se retrouve alors en situation de monopole (il possède toutes les propriétés) et remporte la partie.", "https://cdn1.philibertnet.com/375938-thickbox_default/monopoly-classique.jpg",15.00, c1, m6);
		Jeu j7 = new Jeu(null, "Trivial Pursuit", 2, 11, 8, "Facile", 30, "Un jeu de connaissances pour toute la famille\r\nDans cette nouvelle édition familiale de Trivial Pursuit, le célèbre jeu de connaissances, les enfants vont pouvoir défier les parents sur une multitude de nouvelles questions !\r\nLe principe du jeu reste inchangé : les joueurs ont pour objectif de répondre aux questions pour avancer sur le plateau de jeu. En cas de bonne réponse dans une zone \"triangle\" le joueur gagne le marqueur de la couleur correspondante. Le premier joueur à remplir son \"camembert\" de six marqueurs différents remporte la partie.\r\n\r\nGrâce à ses 1 200 questions spécialement adaptées aux enfants et ses 1 200 questions conçues pour les parents, cette version est idéale pour les parties en famille. Chaque joueur pourra alors prendre plaisir en répondant à des questions correspondant à son niveau de difficulté.", "Comment jouer à Trivial Pursuit Famille ? \r\nLorsque tous les joueurs ont choisi leur camembert et que les cartes enfants et les cartes adultes sont correctement placées sur la table, la partie peut alors commencer.\r\nLancez le dé pour déterminer qui commence. La valeur la plus forte commence.\r\nÀ votre tour, lancez le dé et déplacez votre camembert en fonction de la valeur indiquée sur le dé. Vous pouvez vous déplacer dans n'importe quel sens mais vous n'avez pas le droit de faire marche arrière dans un même déplacement.\r\nSi vous vous arrêtez sur une case \"triangle\", le joueur à votre gauche vous pose une question relevant de la catégorie correspondant à la case.\r\nSi la réponse est bonne, vous remportez le triangle que vous devrez placer dans votre camembert. Si la réponse est mauvaise, le triangle sera pour une autre fois. Dans les deux cas, votre tour est terminé.\r\nLe joueur situé à votre gauche débute son tour et lance le dé.\r\nLa partie se poursuit ainsi jusqu'à ce qu'un joueur remporte 6 triangles différents.\r\nLorsqu'un joueur dispose d'un camembert plein, la partie ne s'arrête pas pour autant. Pour remporter la partie, il devra retourner sur la case centrale en obtenant la valeur exacte avec le dé. Lorsqu'il y parvient, il devra alors répondre à une dernière question, soigneusement choisie par les autres joueurs. En cas de bonne réponse, le joueur remporte la partie. Sinon, il devra retenter sa chance selon le même processus.", "https://cdn3.philibertnet.com/413389-thickbox_default/trivial-pursuit-famille.jpg",15.00, c1, m6);
		Jeu j8 = new Jeu(null, "Puissance 4", 2, 2, 6, "Facile", 15, "Un jeu simple mais stratégique\r\nDans Puissance 4, deux joueurs s'affrontent en face-à-face dans le but de parvenir à aligner horizontalement, verticalement ou en diagonale 4 jetons d'une même couleur.", "Comment jouer à Puissance 4 ?\r\nPour jouer à Puissance 4, rien de plus simple ! \r\n\r\nUne partie débute par la désignation du premier joueur. \r\nUne fois déterminé, celui-­ci choisit sa couleur (jaune ou rouge) et commence la partie en mettant un jeton de sa couleur dans l’une des colonnes de son choix. Subissant la gravité, le jeton se place alors tout en bas de la colonne.\r\nLe deuxième joueur place à son tour un jeton de sa couleur dans la colonne de son choix. \r\nPuis c'est à nouveau au premier joueur de jouer. La partie se poursuit ainsi jusqu'à ce qu'un joueur obtienne une rangée de 4 jetons de sa couleur.\r\nEt le gagnant est... \r\nPour vaincre son adversaire, l'heureux gagnant doit être le premier à aligner 4 jetons de sa couleur horizontalement, verticalement et en diagonale. Si les joueurs ont joué tous leurs jetons sans réussir à aligner 4 jetons, la partie est déclarée nulle.", "https://cdn1.philibertnet.com/471635-thickbox_default/puissance-4.jpg",10.00, c1, m6);
		Jeu j9 = new Jeu(null, "Croque Carotte", 2, 4, 4, "Facile", 30, "Gravis la montagne mais attention aux pièges !\r\n\r\nCroque carotte plonge votre enfant au coeur d'une course de lapins totalement déjantée ! C'est la course à la carotte ! Chaque lapin se dépêche pour être le premier à croquer la carotte mais attention ! Des trous s'ouvrent sous leurs pattes, les ralentissant ainsi brutalement dans leur course folle !\r\n\r\nRapidité et prudence sont de pairs pour garantir la réussite !", "J'en sais rien j'y ai jamais joué.", "https://cdn2.philibertnet.com/369471-large_default/croque-carotte.jpg",8.00, c1, m7);
		Jeu j10 = new Jeu(null, "Risk", 2, 6, 10, "Moyen", 90, "Le jeu de conquête stratégique ! Le monde appartient aux audacieux, l'êtes-vous assez pour gagner ?\r\n\r\nDéplacez vos régiments, choisissez votre stratégie et que la conquête du monde commence !\r\n\r\nVotre mission :\r\n\r\nmettre vos ennemis en déroute,\r\nfaire avancer vos soldat pour conquérir de nouveaux territoires.\r\nQuand attaquer ? Quand s'arrêter ? Faut-il former des alliances avec l'ennemi ? La décision vous appartient !", "Je sais pas du tout dsl", "https://cdn2.philibertnet.com/339595-thickbox_default/risk-vf.jpg",15.00, c1, m6);
		Jeu j11 = new Jeu(null, "Elefun", 1, 3, 3, "Facile", 15, "Description\r\nLe mignon éléphant Elefun de Hasbro souffle des papillons colorés de sa trompe ! Utilise ton filet pour attraper un maximum de papillons au gré des musiques. Celui qui a réussi à en avoir le plus dans son filet remporte la partie.", "Y a pas de règles, c'est juste un éléphant plein de fun", "https://media1.auchan.fr/images/hce/h5b/14724813029406.jpg",8.00, c1, m6);
		Stream.of(j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11).forEach(j -> jeuRepo.save(j));
		
		
		
		JeuAchat ja1 = new JeuAchat(null, 40.50, 100, j1);
		JeuAchat ja2 = new JeuAchat(null, 9.99, 100, j2);
		JeuAchat ja3 = new JeuAchat(null, 54.00, 100, j3);
		JeuAchat ja4 = new JeuAchat(null, 18.90, 100, j4);
		JeuAchat ja5 = new JeuAchat(null, 20.90, 100, j5);
		JeuAchat ja6 = new JeuAchat(null, 42.99, 100, j6);
		JeuAchat ja7 = new JeuAchat(null, 34.99, 100, j7);
		JeuAchat ja8 = new JeuAchat(null, 25.99, 100, j8);
		JeuAchat ja9 = new JeuAchat(null, 25.99, 100, j9);
		JeuAchat ja10 = new JeuAchat(null, 38.99, 100, j10);
		JeuAchat ja11 = new JeuAchat(null, 27.99, 100, j11);
		Stream.of(ja1,ja2,ja3,ja4,ja5,ja6,ja7,ja8,ja9,ja10,ja11).forEach(ja -> jaRepo.save(ja));
		
		
		
		Forum f1 = new Forum(null, "Délais de livraison");
		Forum f2 = new Forum(null, "Retour/Echange");
		Forum f3 = new Forum(null, "Disponibilité des jeux");
		Forum f4 = new Forum(null, "Réservations de salles");
		Forum f5 = new Forum(null, "Remboursement");
		Forum f6 = new Forum(null, "Autres");
		
		
		Stream.of(f1, f2, f3, f4, f5,f6).forEach(a -> forumRepo.save(a));
		
		Message me1= new Message(null, null, "Quels sont les délais de livraison ?", asterix, null, f1, false);
		Message me2= new Message(null, null, "Est-il possible de se faire rembourser un jeu ?", obelix, null, f5, false);
		Message me3= new Message(null, null, "La dernière version du jeu Monopoly est-elle disponible en commande chez vous ?", panoramix, null, f2, false);
		Message me4= new Message(null, null, "Serait-il possible de réserver une salle pour 15 dans 1 mois ?", obelix, null, f3, false);
		Message me5= new Message(null, null, "J'ai reçu mon jeu, il est imcomplet, comment se passe l'échange ?", u5, null, f2, false);
		Message me6= new Message(null, null, "Salut Pano, viens-tu dimanche jouer dans une des salles ?", u5, panoramix, null, true);
		Message me7= new Message(null, null, "Bonjour obélix, j'ai loué 7 wonders, ça te dirait de venir jouer une partie ?", asterix, obelix, null, true);
		Message me8= new Message(null, null, "Livrez-vous au Canada ?", u5, null, f1, false);
		Message me9= new Message(null, null, "Le jeu labyrinthe est-il disponible en location chez-vous ?", asterix, null, f2, false);
		Message me10= new Message(null, null, "Bonjour, quelle est la plus grand salle que vous mettez à disposition pour une réservation ?", panoramix, null, f3, false);
		Message me11= new Message(null, null, "Le jeu que j'ai acheté ne convient pas à la personne à qui je l'ai offert, puis-je me le faire rembourser?", panoramix, null, f5, false);
		Stream.of(me1, me2, me3, me4, me5, me6, me7, me8, me9, me10, me11).forEach(a -> messageRepo.save(a));
		
		JeuLocation jl1 = new JeuLocation(null, j1);
		JeuLocation jl2 = new JeuLocation(null, j2);
		JeuLocation jl3 = new JeuLocation(null, j3);
		JeuLocation jl4 = new JeuLocation(null, j4);
		JeuLocation jl5 = new JeuLocation(null, j5);
		JeuLocation jl6 = new JeuLocation(null, j6);
		JeuLocation jl7 = new JeuLocation(null, j7);
		JeuLocation jl8 = new JeuLocation(null, j8);
		JeuLocation jl9 = new JeuLocation(null, j9);
		JeuLocation jl10 = new JeuLocation(null, j10);
		JeuLocation jl11 = new JeuLocation(null, j11);
		JeuLocation jl12 = new JeuLocation(null, j1);
		Stream.of(jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12).forEach(jl -> jlRepo.save(jl));
		
		
		Admin a1 = new Admin(null,panoramix);
		Admin a2 = new Admin(null,u4);
		Stream.of(a1,a2).forEach(a -> adminRepo.save(a));
		
		Vendeur v1 = new Vendeur(null,u5);

		Stream.of(v1).forEach(a -> vendeurRepo.save(a));
		
		
		
		Avis av1 = new Avis(null, 5,"Pas terrible, je me suis ennuyé", asterix, j1);
		Avis av2 = new Avis(null, 9,"Game night de folie!!!! Super bon moment passé avec Panoramix et Idéfix", obelix, j1);
		Avis av3 = new Avis(null, 7,"Je préfère boire quand même", obelix, j2);
		Stream.of(av1, av2, av3).forEach(a -> avisRepo.save(a));


		JeuDansPanier jdp1 = new JeuDansPanier(null, u5, ja2, 3,true);
		JeuDansPanier jdp2 = new JeuDansPanier(null, u5, ja4, 2,true);
		JeuDansPanier jdp3 = new JeuDansPanier(null, u5, ja5, 1,false);
		JeuDansPanier jdp4 = new JeuDansPanier(null, u5, ja6, 3,true);
		JeuDansPanier jdp5 = new JeuDansPanier(null, u5, ja8, 1,false);
		JeuDansPanier jdp6 = new JeuDansPanier(null, u5, ja9, 2,false);
		JeuDansPanier jdp7 = new JeuDansPanier(null, u5, ja11, 3,true);
		JeuDansPanier jdp8 = new JeuDansPanier(null, u4, ja1, 3,true);
		JeuDansPanier jdp9 = new JeuDansPanier(null, u4, ja3, 2,true);
		JeuDansPanier jdp10 = new JeuDansPanier(null, u4, ja4, 3,true);
		Stream.of(jdp1,jdp2,jdp3,jdp4,jdp5,jdp6,jdp7,jdp8,jdp9,jdp10).forEach(jdp -> jeudanspanierRepo.save(jdp));
		

		Stream.of(jdp1,jdp2,jdp3,jdp4,jdp5,jdp6,jdp7,jdp8).forEach(jdp -> jeudanspanierRepo.save(jdp));

		Salle s1 = new Salle(null, "Paris", 20.0, 8, true, "https://cdn.pixabay.com/photo/2015/05/15/14/27/eiffel-tower-768501_960_720.jpg");
        Salle s2 = new Salle(null, "Lyon", 20.0, 8, true, "https://cdn.pixabay.com/photo/2017/06/08/08/28/lyon-2382879_960_720.jpg");
        Salle s3 = new Salle(null, "Strasbourg", 10.0, 4, false, "https://cdn.pixabay.com/photo/2019/07/21/01/43/city-4351840_960_720.jpg");
        Salle s4 = new Salle(null, "Toulouse", 10.0, 4, true, "https://cdn.pixabay.com/photo/2020/01/07/12/21/toulouse-4747440_960_720.jpg");
        Salle s5 = new Salle(null, "Bordeaux", 20.0, 8, true, "https://cdn.pixabay.com/photo/2017/04/05/10/51/bordeaux-2204634_960_720.jpg"); 

        Stream.of(s1, s2, s3, s4, s5).forEach(s -> salleRepo.save(s));


	}

}
