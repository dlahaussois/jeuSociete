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
import fr.solutec.entities.HistoriqueJeuAchat;
import fr.solutec.entities.HistoriqueJeuLocation;
import fr.solutec.entities.HistoriqueLocationSalle;
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
import fr.solutec.repository.HistoriqueJeuAchatRepository;
import fr.solutec.repository.HistoriqueJeuLocationRepository;
import fr.solutec.repository.HistoriqueLocationSalleRepository;
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
	
	@Autowired
	HistoriqueLocationSalleRepository histoRepo;
	
	@Autowired
	HistoriqueJeuLocationRepository histojeulocationRepo;
	
	@Autowired
	HistoriqueJeuAchatRepository histojeuachatRepo;

	public static void main(String[] args) {
		SpringApplication.run(JeuxDeSocieteApplication.class, args);
		
		
		System.out.println("Fin du programme");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test");
		User asterix = new User(null, "asterix", "azerty", "asterix.legaulois@village-gaulois.ga", "06.65.83.92.01",true);
		User obelix = new User(null, "obelix", "sanglier","obelix.lebg@village-gaulois.ga", "07.23.54.74.36",true);
		User panoramix = new User(null, "panoramix", "potion","pano.ledruide@village-gaulois.ga", "01.35.28.75.64",true );
		User u4 = new User(null, "Admin", "Admin","admin@admin.fr", "01.35.28.75.64",true );
		User u5 = new User(null, "Vendeur", "Vendeur","vendeur@vendeur.fr", "01.35.28.75.64",true );
		User u6 = new User(null, "Abraracourcix", "chef","courtsurpatte.maisrapide@village-gaulois.ga", "01.52.36.69.27",true );
		User u7 = new User(null, "C??tautomatix", "marteau","leplusfort@village-gaulois.ga", "01.35.28.75.64",true );
		User u8 = new User(null, "Id??fix", "ouaf","toutou@village-gaulois.ga", "",false );
		User u9 = new User(null, "C??sar", "laurier","empereur-romain@rome.ro", "01.35.28.75.64",true );
		User u10 = new User(null, "Cl??opatre", "lion","reine-toutepuissante@rome.ro", "03.84.15.76.34",true );
		
		Stream.of(asterix, obelix, panoramix, u4, u5, u6, u7, u8, u9, u10).forEach(c -> userRepo.save(c));

		
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
		Joueur jo3 = new Joueur(null,false,u6);
		Joueur jo4 = new Joueur(null,false,u7);
		Joueur jo5 = new Joueur(null,false,u8);
		
		

		Stream.of(jo1,jo2, jo3, jo4, jo5).forEach(jo -> joueurRepo.save(jo));
		
		System.out.println(jo1);
		
		Jeu j1 = new Jeu(null, "7 Wonders Nouvelle Edition", 3, 7, 10, "Difficile", 30, "7 Wonders, un jeu mythique\r\nDans 7 Wonders, vous ??tes ?? la t??te de l'une des sept grandes cit??s du monde antique. Votre but est de faire prosp??rer votre ville pour la rendre plus influente que celles de vos adversaires. Le futur des cit??s l??gendaires comme Babylone, ??ph??se ou encore Rhodes d??pend de vos talents de gestionnaire. Pour inscrire votre cit?? dans l'Histoire, vous devrez agir dans diff??rents secteurs de d??veloppement. Exploitez les ressources naturelles de vos terres, participez aux progr??s scientifiques, d??veloppez vos relations commerciales et affirmez votre supr??matie militaire. Laissez votre empreinte dans l'histoire des civilisations en b??tissant une merveille monumentale.\r\n\r\n7 Wonders, un jeu de draft ?? travers 3 ??ges\r\nUne partie se d??roule ?? travers 3 ??ges successifs comportant chacun 6 tours de jeu. Chaque ??poque se joue de mani??re identique et repose sur un syst??me de draft. Chaque joueur choisit une carte de sa main, la joue et passe les cartes restantes au joueur suivant. Ce principe de jeu permet aux diff??rents paquets de cartes de tourner entre les joueurs qui ont donc 6 cartes pour d??velopper au mieux leur strat??gie. ?? chaque tour, les participants ont 3 actions possibles : construire leur cit??, d??velopper leur merveille ou gagner de l'argent.\r\n\r\n7 Wonders, un jeu strat??gique\r\nPour r??gner en ma??tre, les joueurs devront ??tablir une strat??gie et composer avec leurs cartes pour d??rouler leur plan d'actions sans encombre. Le jeu leur offre aussi la possibilit?? d'interagir avec les autres joueurs en b??n??ficiant de certains avantages tir??s des cartes jou??es. ?? la fin du 3??me ??ge, les joueurs devront compter leurs points de victoire. Le score final d??pendra des b??timents construits (commerciaux, civils et scientifiques), du stade de d??veloppement de leur merveille, des victoires militaires et des fortunes engrang??es. 7 Wonders est un jeu strat??gique o?? les joueurs ne doivent oublier aucun aspect du jeu pour triompher. La cit?? doit prosp??rer sur le plan civil, scientifique, commercial et militaire. Autrement dit, leur cit?? devra ??tre belle, riche et puissante. Le joueur avec le score le plus ??lev?? est d??clar?? vainqueur.\r\n\r\nLes 7 valeurs ajout??es de la nouvelle ??dition de 7 Wonders\r\nune refonte graphique du jeu. Sorti en 2010 et accumulant plus de 30 prix internationaux, 7 Wonders m??ritait de se refaire une beaut?? ! La couverture, le design des cartes, les merveilles, le thermoformage: tout y est pass?? !\r\nLa r??daction des r??gles a enti??rement ??t?? revue pour les rendre plus simples d???acc??s aux d??butants. Fini les longues pages ?? lire, on passe maintenant ?? un livret de r??gles de 8 pages beaucoup plus facile ?? appr??hender et ?? comprendre !\r\nL???aide de jeu aussi a ??t?? totalement repens??e.\r\nGr??ce ?? une meilleure ergonomie des cartes, le joueur gagne de la place ?? table. Le nouvel agencement des cartes permet une lecture facile des informations. Les cartes guildes, dispers??es dans les diff??rentes extensions de 7 Wonders, ont ??t?? rassembl??es et ajout??es au nouveau jeu de base.\r\nLa taille des merveilles a augment?? permettant une meilleure immersion du jeu avec le th??me principal de 7 Wonders, ses merveilles ! Le format de la bo??te du jeu de base et de ses extensions sera aussi plus grand, adoptant une taille de bo??te standard. Toujours pour respecter au mieux l???immersion dans le jeu, les faces A et B des merveilles ont ??t?? repens??es et sont remplac??es par une face jour et une face nuit. D??couvrez les merveilles sous leur aspect diurne et nocturne!\r\n7 Wonders s???inspire aussi du cha??nage de 7 Wonders Duel, plus ergonomique et plus intuitif.\r\nGr??ce aux symboles int??gr??s discr??tement dans le contenu du jeu, 7 Wonders et ses extensions sont maintenant adapt??s aux joueurs daltoniens.", "Le Tarot se joue ?? quatre joueurs.\r\n"+ "Le Tarot est ?? la fois un jeu individuel et un jeu d'??quipe. En effet, au cours de la partie,\r\n"+ "l'un des joueurs, appel?? le preneur (ou le d??clarant) est oppos?? aux trois autres, les\r\n"+ "d??fenseurs, qui constituent une ??quipe (la D??fense).\r\n"+ "Mais cette association ne dure que le temps d'une Donne. Elle peut se constituer\r\n"+ "diff??remment pour la donne suivante.\r\n"+ "Apr??s avoir pris connaissance de son jeu, un joueur peut s'engager ?? atteindre un\r\n"+ "certain nombre de points en jouant seul contre ses trois adversaires associ??s.","https://alloescape.fr/wp-content/uploads/2018/05/7-wonders-vf.jpg",8.10,c1,m1);
		Jeu j2 = new Jeu(null, "Tarot de Comp??tition", 4, 5, 10, "Difficile", 15, "Jeu de tarot traditionnel de 78 cartes, dos ??cossais, avec r??gles du jeu en fran??ais. Dimensions 6 x 11,5 cm. Convient pour les comp??titions.", "Le Tarot se joue ?? quatre joueurs.\r\n"+ "Le Tarot est ?? la fois un jeu individuel et un jeu d'??quipe. En effet, au cours de la partie,\r\n"+ "l'un des joueurs, appel?? le preneur (ou le d??clarant) est oppos?? aux trois autres, les\r\n"+ "d??fenseurs, qui constituent une ??quipe (la D??fense).\r\n"+ "Mais cette association ne dure que le temps d'une Donne. Elle peut se constituer\r\n"+ "diff??remment pour la donne suivante.\r\n"+ "Apr??s avoir pris connaissance de son jeu, un joueur peut s'engager ?? atteindre un\r\n"+ "certain nombre de points en jouant seul contre ses trois adversaires associ??s.","https://th.bing.com/th/id/R6128da36e385f1010d021a9fd940ac79?rik=EymV%2f9pJfmXJug&pid=ImgRaw",2.00,c2,m2);
		Jeu j3 = new Jeu(null, "Heroes of Stalingrad", 2, 2, 14, "Moyen",45 , "Heroes of Stalingrad est le nouveau Wargame sign?? Devil Pig Games. Plongez gr??ce aux m??caniques dynamiques et strat??giques du Heroes System : Tactical Scale, dans l???une des batailles les plus d??cisives de la Seconde Guerre mondiale. A deux durant des parties de 30 minutes et plus, vous incarnerez les plus grands h??ros de ce conflit dans le pur style des films de guerre.\r\n\r\nQue vous connaissiez ou non nos autres jeux utilisant ces m??caniques, Heroes of Stalingrad est la bo??te de base id??ale pour d??couvrir le Heroes System : Tactical Scale au rythme des chants patriotiques des commissaires politiques bravant MG34 et DP28 !", "Sur le terrain, vos forces sont repr??sent??es ?? l???aide de pions\r\n"+ "Unit??. Chaque pion pr??sente l???int??gralit?? des informations\r\n"+ "n??cessaires pour jouer cette Unit?? : Valeur de Combat, Valeur\r\n"+ "de D??fense, Valeur de Mouvement, ainsi que les Capacit??s\r\n"+ "Sp??ciales que cette Unit?? peut utiliser.\r\n"+ "Afin de vous aider dans la constitution et l???organisation de\r\n"+ "votre arm??e, Heroes of Stalingrad propose un syst??me de\r\n"+ "Tuiles et d???Options de Recrutement. Ces tuiles permettront un\r\n"+ "meilleur suivi de vos forces arm??es et de leurs capacit??s ??? et de\r\n"+ "d??terminer quand elles auront atteint leur Point de Rupture !\r\n"+ "?? chaque Tour de Jeu, vous utiliserez secr??tement vos pions\r\n"+ "Ordre pour commander certaines de vos Unit??s et d??terminer\r\n"+ "l???ordre dans lequel elles agiront.\r\n"+ "Chacune de ces Unit??s peut effectuer une Action de Mouvement\r\n"+ "??? afin d???occuper une position strat??gique ou de capturer un\r\n"+ "objectif ??? ou attaquer l???ennemi en r??alisant une Action de Tir.\r\n"+ "Votre adversaire et vous activerez vos Unit??s les unes apr??s les\r\n"+ "autres, en alternance. Une fois tous vos pions Ordre activ??s, le\r\n"+ "reste de vos forces arm??es aura l???opportunit?? de man??uvrer.\r\n"+ "Vous vous pr??parerez ensuite au tour suivant", "https://www.espritjeu.com/upload/image/heroes-of-stalingrad-p-image-70586-grande.jpg",10.80, c3, m3);
		Jeu j4 = new Jeu(null, "Puzzle Inner Mystic 1000 Pi??ces", 1, 1, 10, "Difficile", 120, "Puzzle de 1000 pi??ces en carton de la marque HEYE.\r\nFormat : Paysage\r\nDimensions : 50x70 cm\r\nFabriqu?? avec du carton recycl??.\r\nSous le ciel grandiose r??ve une petite cr??ature mythique. Si vous regardez de plus pr??s en faisant le puzzle, vous d??couvrirez l'attention incroyablement affectueuse qu'Andy Kehoe porte aux d??tails.", "Assemblez les pi??ces pour reproduire le motif.", "https://cdn1.philibertnet.com/503142-thickbox_default/puzzle-inner-mystic-1000-pieces.jpg",3.90, c4, m4);
		Jeu j5 = new Jeu(null, "Puzzle Van Gogh, 1000 Pi??ces", 1, 1, 10, "Difficile", 120, "Puzzle classique de 1000 pi??ces\r\nFormat:Paysage\r\nDimensions :\r\n46 cm x 65 cm\r\nArtiste maudit et incompris, esprit sensible et tortur??, Vincent Van Gogh (1853???1890) est devenu une l??gende. R??put?? inclassable, il appartient pourtant ?? la mouvance postimpressionniste, tout comme son ami Paul Gauguin. Avec sa palette vive et sa touche exalt??e, il appara??t aussi comme un pr??curseur du fauvisme et de l???expressionnisme tout en se rapprochant du symbolisme par sa conception mystique de l???art. Peintre infatigable mort ?? 37 ans, il a produit plus de 800 toiles. Associant r??flexions sur la forme et sur la couleur, la d??marche de Vincent Van Gogh incarne parfaitement le g??nie de l???art moderne.\r\nLa Nuit ??toil??e, 1889\r\n\r\n?? Souvent, il me semble que la nuit est encore plus richement color??e que le jour ??, ??crivit le peintre. Ce paysage nocturne fut r??alis?? depuis la chambre que Vincent Van Gogh occupait ?? l???asile de Saint-R??my-de-Provence. Il se singularise par le traitement du ciel, qui occupe la majeure partie de la toile. Le mouvement tourbillonnant de l???air forme des vagues, et les ??toiles ??tincellent comme autant de soleils. La touche est fragment??e, les couleurs sont pures. L???agitation du ciel contraste avec la tranquillit?? du village endormi. Vincent Van Gogh exprime ici sa vision mystique du monde, ?? la recherche d???une v??rit?? invisible.", "Assemblez les pi??ces pour reproduire le motif.", "https://th.bing.com/th/id/OIP.5xz0_7eK-qVQexDWRK5SrAAAAA?pid=ImgDet&rs=1",4.18, c4, m7);
		Jeu j6 = new Jeu(null, "Monopoly, \nVersion Fran??aise", 2, 6, 8, "Facile", 45, "Le jeu de soci??t?? le plus c??l??bre du monde !\r\nOn ne pr??sente plus le Monopoly. ??dit?? pour la premi??re fois en 1935, ce jeu de soci??t?? incontournable, ayant pour th??me central les transactions immobili??res, s'est impos?? au fil des d??cennies comme ??tant le plus gros succ??s du monde ludique. \r\n\r\nLe but du jeu est simple : les joueurs doivent acheter, vendre, construire et sp??culer pour s'enrichir un maximum tout en for??ant les autres ?? faire faillite. \r\nPour ??tre d??clar?? gagnant, les joueurs devront acheter des propri??t??s afin de s'enrichir le plus possible. Plus ils poss??deront de propri??t??s, plus ils auront d'argent.\r\n\r\nLe Monopoly est un jeu familial qui demande une bonne strat??gie et une bonne gestion tout en int??grant une dimension de chance et de hasard. Cette version classique est adapt??e ?? toute la famille et conviendra aussi bien aux adultes qu'aux enfants.\r\n\r\nChaque ann??e, le Monopoly fait partie des jeux de soci??t?? les plus vendus en France et dans le monde. Le jeu n'a cess?? de se r??inventer et se d??cline aujourd'hui en plusieurs versions et ??ditions (France, villes fran??aises, Nintendo, Fortnite, ??dition Tricheurs, etc.).", "Comment jouer au Monopoly ?\r\nUne partie de Monopoly se d??roule en plusieurs tours de jeu o?? les joueurs jouent successivement. ?? son tour, le joueur lance les deux d??s, avance son pion sur le parcours en fonction de la valeur obtenue, puis effectue une action d'apr??s la nature de la case sur laquelle il est arr??t?? :\r\n\r\nLe Monoply se pr??sente sous la forme d'un plateau de jeu compos?? de diff??rentes cases sur lesquelles circulent les joueurs, repr??sent??s pour leur pion. Il existe plusieurs types de cases : \r\n\r\nLes cases Propri??t??s repr??sentent des avenues, des places, des chemins de fer ou des services publiques. Il s'agit des cases que les joueurs pourront acqu??rir pour faire fortune.\r\nLes cases R??compenses correspondent ?? des emplacements qui apporteront un avantage aux joueurs. Il existe diff??rentes cases R??compenses, comme la case Chance, la case D??part, la case Caisse de Communaut?? ou encore la case Parc Gratuit.\r\nLes cases P??nalit??s repr??sentent les emplacements que les joueurs pr??f??reront ??viter comme la case Allez en prison, la case Prison, la Taxe de luxe ou encore la case Imp??t sur le revenu.\r\nLa case Simple visite : celle-ci repr??sente un emplacement neutre, c'est-??-dire qui n'a aucun effet sur les joueurs.\r\nUne partie de Monopoly peut durer entre 1h et 2h au maximum. Le jeu prend fin lorsqu'un joueur est le dernier ?? ne pas avoir fait faillite. Il se retrouve alors en situation de monopole (il poss??de toutes les propri??t??s) et remporte la partie.", "https://www.moviemaniauk.co.uk/assets/Hasbro-Monopoly-Classic-Board-Game-1.jpg",15.00, c1, m6);
		Jeu j7 = new Jeu(null, "Trivial Pursuit, Classic Edition", 2, 11, 8, "Facile", 30, "Un jeu de connaissances pour toute la famille\r\nDans cette nouvelle ??dition familiale de Trivial Pursuit, le c??l??bre jeu de connaissances, les enfants vont pouvoir d??fier les parents sur une multitude de nouvelles questions !\r\nLe principe du jeu reste inchang?? : les joueurs ont pour objectif de r??pondre aux questions pour avancer sur le plateau de jeu. En cas de bonne r??ponse dans une zone \"triangle\" le joueur gagne le marqueur de la couleur correspondante. Le premier joueur ?? remplir son \"camembert\" de six marqueurs diff??rents remporte la partie.\r\n\r\nGr??ce ?? ses 1 200 questions sp??cialement adapt??es aux enfants et ses 1 200 questions con??ues pour les parents, cette version est id??ale pour les parties en famille. Chaque joueur pourra alors prendre plaisir en r??pondant ?? des questions correspondant ?? son niveau de difficult??.", "Comment jouer ?? Trivial Pursuit Famille ? \r\nLorsque tous les joueurs ont choisi leur camembert et que les cartes enfants et les cartes adultes sont correctement plac??es sur la table, la partie peut alors commencer.\r\nLancez le d?? pour d??terminer qui commence. La valeur la plus forte commence.\r\n?? votre tour, lancez le d?? et d??placez votre camembert en fonction de la valeur indiqu??e sur le d??. Vous pouvez vous d??placer dans n'importe quel sens mais vous n'avez pas le droit de faire marche arri??re dans un m??me d??placement.\r\nSi vous vous arr??tez sur une case \"triangle\", le joueur ?? votre gauche vous pose une question relevant de la cat??gorie correspondant ?? la case.\r\nSi la r??ponse est bonne, vous remportez le triangle que vous devrez placer dans votre camembert. Si la r??ponse est mauvaise, le triangle sera pour une autre fois. Dans les deux cas, votre tour est termin??.\r\nLe joueur situ?? ?? votre gauche d??bute son tour et lance le d??.\r\nLa partie se poursuit ainsi jusqu'?? ce qu'un joueur remporte 6 triangles diff??rents.\r\nLorsqu'un joueur dispose d'un camembert plein, la partie ne s'arr??te pas pour autant. Pour remporter la partie, il devra retourner sur la case centrale en obtenant la valeur exacte avec le d??. Lorsqu'il y parvient, il devra alors r??pondre ?? une derni??re question, soigneusement choisie par les autres joueurs. En cas de bonne r??ponse, le joueur remporte la partie. Sinon, il devra retenter sa chance selon le m??me processus.", "https://images-na.ssl-images-amazon.com/images/I/91v7zkjzh3L._AC_SX522_.jpg",15.00, c1, m6);
		Jeu j8 = new Jeu(null, "Puissance 4, Le Jeu Original", 2, 2, 6, "Facile", 15, "Un jeu simple mais strat??gique\r\nDans Puissance 4, deux joueurs s'affrontent en face-??-face dans le but de parvenir ?? aligner horizontalement, verticalement ou en diagonale 4 jetons d'une m??me couleur.", "Comment jouer ?? Puissance 4 ?\r\nPour jouer ?? Puissance 4, rien de plus simple ! \r\n\r\nUne partie d??bute par la d??signation du premier joueur. \r\nUne fois d??termin??, celui-??ci choisit sa couleur (jaune ou rouge) et commence la partie en mettant un jeton de sa couleur dans l???une des colonnes de son choix. Subissant la gravit??, le jeton se place alors tout en bas de la colonne.\r\nLe deuxi??me joueur place ?? son tour un jeton de sa couleur dans la colonne de son choix. \r\nPuis c'est ?? nouveau au premier joueur de jouer. La partie se poursuit ainsi jusqu'?? ce qu'un joueur obtienne une rang??e de 4 jetons de sa couleur.\r\nEt le gagnant est... \r\nPour vaincre son adversaire, l'heureux gagnant doit ??tre le premier ?? aligner 4 jetons de sa couleur horizontalement, verticalement et en diagonale. Si les joueurs ont jou?? tous leurs jetons sans r??ussir ?? aligner 4 jetons, la partie est d??clar??e nulle.", "https://virginmegastore.ma/storage/2020/04/Jeu-Puissance-4-Nouvelle-Edition.jpg",10.00, c1, m6);
		Jeu j9 = new Jeu(null, "Croque Carotte, Version Fran??aise", 2, 4, 4, "Facile", 30, "Gravis la montagne mais attention aux pi??ges !\r\n\r\nCroque carotte plonge votre enfant au coeur d'une course de lapins totalement d??jant??e ! C'est la course ?? la carotte ! Chaque lapin se d??p??che pour ??tre le premier ?? croquer la carotte mais attention ! Des trous s'ouvrent sous leurs pattes, les ralentissant ainsi brutalement dans leur course folle !\r\n\r\nRapidit?? et prudence sont de pairs pour garantir la r??ussite !", "J'en sais rien j'y ai jamais jou??.", "https://images-na.ssl-images-amazon.com/images/I/910AKbmcjjL._AC_SY450_.jpg",8.00, c1, m7);
		Jeu j10 = new Jeu(null, "Risk, Jeu de Strat??gie", 2, 6, 10, "Moyen", 90, "Le jeu de conqu??te strat??gique ! Le monde appartient aux audacieux, l'??tes-vous assez pour gagner ?\r\n\r\nD??placez vos r??giments, choisissez votre strat??gie et que la conqu??te du monde commence !\r\n\r\nVotre mission :\r\n\r\nmettre vos ennemis en d??route,\r\nfaire avancer vos soldat pour conqu??rir de nouveaux territoires.\r\nQuand attaquer ? Quand s'arr??ter ? Faut-il former des alliances avec l'ennemi ? La d??cision vous appartient !", "Je sais pas du tout dsl", "https://www.cdiscount.com/pdt2/0/1/0/1/700x700/hasb74041010/rw/risk-jeu-de-societe-de-strategie-jeu-de-platea.jpg",15.00, c1, m6);
		Jeu j11 = new Jeu(null, "Elefun Chasse aux Papillons", 1, 3, 3, "Facile", 15, "Le mignon ??l??phant Elefun de Hasbro souffle des papillons color??s de sa trompe ! Utilise ton filet pour attraper un maximum de papillons au gr?? des musiques. Celui qui a r??ussi ?? en avoir le plus dans son filet remporte la partie.", "Y a pas de r??gles, c'est juste un ??l??phant plein de fun", "https://images-na.ssl-images-amazon.com/images/I/910JQj7v76L._AC_SL1500_.jpg",8.00, c1, m6);
		Jeu j12 = new Jeu(null, "Cluedo, The Classic Mystery Game", 2, 6, 8, "Difficile", 30, "Dans ce jeu Cluedo ?? suspense, les joueurs doivent d??couvrir qui est responsable du meurtre du Dr Black de Tudor Mansion dans sa propre maison. Obtenez le scoop sur les chambres, les armes et les invit??s du manoir et commencez ?? d??tecter. ??tait-ce Mme Pervenche avec la cl?? dans la biblioth??que? Ou bien M. Leblanc avec le chandelier dans le cabinet d'??tudes? ??liminez les informations tout au long du jeu dans ce polar classique. Le joueur qui accuse correctement qui, quoi et o?? gagne!", "Eliminer les suspects et d??couvrir le meurtier, l'arme et la salle du crime.\r\n Pr??sentation d un nouveau personnage, le Dr Violet comme l'un des suspects.\r\n Fouillez le manoir pour trouver des indices, posez des questions de d??tective astucieuses et ne laissez aucune carte non retourn??e.\r\n R??solvez d'abord le meurtre pour gagner!\r\n Une version amusante du jeu myst??re classique propose de nouveaux personnages et une version ?? deux joueurs!", "https://static.alipson.fr/m381/p378381/p1.jpg",10.00, c1, m6);
		Stream.of(j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11, j12).forEach(j -> jeuRepo.save(j));
		
		
		
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
		JeuAchat ja12 = new JeuAchat(null, 44.99, 100, j12);
		Stream.of(ja1,ja2,ja3,ja4,ja5,ja6,ja7,ja8,ja9,ja10,ja11, ja12).forEach(ja -> jaRepo.save(ja));
		
		
		
		Forum f1 = new Forum(null, "Livraison", "fa fa-truck fa-2x");
		Forum f2 = new Forum(null, "Retour et Echange","fa fa-hand-point-left fa-2x");
		Forum f3 = new Forum(null, "Remboursement","fa fa-hand-holding-usd fa-2x");
		Forum f4 = new Forum(null, "R??servation de salles","fa fa-house-user fa-2x");
		Forum f5 = new Forum(null, "Jeux","fa fa-dice fa-2x");
		Forum f6 = new Forum(null, "Autres","fa fa-question-circle fa-2x");
		
		
		Stream.of(f1, f2, f3, f4, f5,f6).forEach(a -> forumRepo.save(a));
		

		Message me1= new Message(null, null, "Quels sont les d??lais de livraison en Gaule ?", asterix, null, f1, null, false);
		Message me2= new Message(null, null, "Est-il possible de se faire rembourser un jeu ?", obelix, null, f3, null, false);
		Message me3= new Message(null, null, "La derni??re version du jeu Monopoly, o?? il est possible d'acheter le palais de C??sar, est-elle disponible en commande chez vous ?", u10, null, f5, null, false);
		Message me4= new Message(null, null, "Serait-il possible de r??server une salle pour l'ensemble du village dans 1 mois ?", obelix, null, f4, null, false);
		Message me5= new Message(null, null, "J'ai re??u mon jeu, il est imcomplet, comment se passe l'??change ?", u6, null, f2, null, false);

		Message me6= new Message(null, null, "Salut Pano, viens-tu dimanche jouer dans une des salles ?", obelix, panoramix, null, null, true);
		Message me7= new Message(null, null, "Bonjour ob??lix, j'ai lou?? 7 wonders, ??a te dirait de venir jouer une partie ?", asterix, obelix, null, null,  true);
		Message me8= new Message(null, null, "Livrez-vous en Germany ?", u9, null, f1, null, false);
		Message me9= new Message(null, null, "Le jeu labyrinthe est-il disponible en location chez-vous ?", asterix, null, f5, null, false);
		Message me10= new Message(null, null, "Bonjour, quelle est la plus grand salle que vous mettez ?? disposition pour une r??servation ?", panoramix, null, f4, null, false);

		Message me11= new Message(null, null, "Le jeu que j'ai achet?? ne convient pas ?? la personne ?? qui je l'ai offert, puis-je me le faire rembourser?", u7, null, f3, null, false);
		Message me12= new Message(null, null, "J'ai oubli?? mon casque Gaulois dans la salle de Lyon (Lugdunum), l'avez-vous r??cup??r???", asterix, null, f6, null, false);
		Message me13= new Message(null, null, "J'ai cr??e un jeu d'??chec g??ant avec des menhirs, je le vend au prix de 500 sesterces. Cela vous int??resse t-il pour votre magasin ?", obelix, null, f6, null, false);
		Message me14= new Message(null, null, "Je n'aime pas le jeu qu'on m'a offert, puis-je l'??changer contre un os ? ouaf!", u8, null, f2, null, false);
		Message me15= new Message(null, null, "Vendez-vous de la cervoise en salle ?", u7, null, f6, null, false);
		Stream.of(me1, me2, me3, me4, me5, me6, me7, me8, me9, me10, me11, me12, me13, me14, me15).forEach(a -> messageRepo.save(a));


		
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
		Admin a3 = new Admin(null,u9);
		
		Stream.of(a1,a2, a3).forEach(a -> adminRepo.save(a));
		
		Vendeur v1 = new Vendeur(null,u5);
		Vendeur v2 = new Vendeur(null,u10);

		Stream.of(v1, v2).forEach(a -> vendeurRepo.save(a));
		
		
		Avis av1 = new Avis(null, 5,"Pas terrible, je me suis ennuy??", asterix, j1);
		Avis av2 = new Avis(null, 9,"Game night de folie!!!! Super bon moment pass?? avec Panoramix et Id??fix", obelix, j1);
		Avis av3 = new Avis(null, 7,"Je pr??f??re boire quand m??me", obelix, j2);
		Avis av4 = new Avis(null, 3,"Ce n'est plus de mon ??ge de faire la guerre...", panoramix, j1);
		Avis av5 = new Avis(null, 8,"Ah les soviets... c'??tait le bon temps", panoramix, j3);
		Avis av6 = new Avis(null, 6,"Beaucoup trop strat??gique pour moi", obelix, j3);
		Avis av7 = new Avis(null, 3,"Un vrai casse-t??te!", obelix, j3);
		Avis av8 = new Avis(null, 9,"Ca me rappelle mon enfance", obelix, j9);
		Avis av9 = new Avis(null, 8,"M??me mon petit Idefix appr??cie de jouer ?? ce jeu!", asterix, j9);
		
		Stream.of(av1, av2, av3, av4, av5, av6, av7, av7, av8, av9).forEach(a -> avisRepo.save(a));


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
        Salle s6 = new Salle(null, "Dijon", 20.0, 8, true, "https://cdn.pixabay.com/photo/2016/11/05/15/04/sculpture-1800411_960_720.jpg"); 
        Salle s7 = new Salle(null, "Montpellier", 20.0, 8, true, "https://cdn.pixabay.com/photo/2017/06/30/00/01/montpellier-2456743_960_720.jpg"); 
        Salle s8 = new Salle(null, "Chamonix", 20.0, 8, true, "https://cdn.pixabay.com/photo/2016/11/16/10/59/mountains-1828596_960_720.jpg"); 
        Salle s9 = new Salle(null, "Ajaccio", 30.0, 12, true, "https://cdn.pixabay.com/photo/2015/09/18/12/59/corsica-945633_960_720.jpg"); 
        Salle s10 = new Salle(null, "Toulon", 10.0, 4, false, "https://cdn.pixabay.com/photo/2012/09/25/14/43/toulon-57914_960_720.jpg"); 

        Stream.of(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10).forEach(s -> salleRepo.save(s));
        
        Date d1 =new SimpleDateFormat("yyyy-mm-dd HH:mm").parse("2021-06-23 8:00");
		Date d2 =new SimpleDateFormat("yyyy-mm-dd HH:mm").parse("2021-06-23 16:00");
		Date d3 =new SimpleDateFormat("yyyy-mm-dd HH:mm").parse("2021-06-23 8:00");
		Date d4 =new SimpleDateFormat("yyyy-mm-dd HH:mm").parse("2021-06-23 16:00");
		Date d5 =new SimpleDateFormat("yyyy-mm-dd HH:mm").parse("2021-06-29 8:00");
		Date d6 =new SimpleDateFormat("yyyy-mm-dd HH:mm").parse("2021-06-29 16:00");
		Date d7 =new SimpleDateFormat("yyyy-mm-dd HH:mm").parse("2021-06-20 8:00");
		Date d8 =new SimpleDateFormat("yyyy-mm-dd HH:mm").parse("2021-06-21 16:00");
		HistoriqueLocationSalle h1 = new HistoriqueLocationSalle(null, d1, d2, false, s1, jo1, v1, jo1);
		HistoriqueLocationSalle h2 = new HistoriqueLocationSalle(null, d3, d4, false, s1, jo2, v1, jo1);
		HistoriqueLocationSalle h3 = new HistoriqueLocationSalle(null, d5, d6, false, s2, jo1, v1, jo1);
		HistoriqueLocationSalle h4 = new HistoriqueLocationSalle(null, d7, d8, false, s3, jo2, v1, jo2);

		Stream.of(h1, h2, h3, h4).forEach(h -> histoRepo.save(h));

		
		HistoriqueJeuLocation hjl1 = new HistoriqueJeuLocation(null, d5, d6, 2, null, jl1, jo1, null, false);
		HistoriqueJeuLocation hjl2 = new HistoriqueJeuLocation(null, d1, d2, 1, null, jl3, jo1, v1, true);
		HistoriqueJeuLocation hjl3 = new HistoriqueJeuLocation(null, d1, d2, 1, null, jl5, jo1, v1, true);
		Stream.of(hjl1,hjl2,hjl3).forEach(hjl -> histojeulocationRepo.save(hjl));
		
		HistoriqueJeuAchat hja1 = new HistoriqueJeuAchat(null, 3, null, ja1, jo1, null, false);
		HistoriqueJeuAchat hja2 = new HistoriqueJeuAchat(null, 2, null, ja3, jo1, null, false);
		HistoriqueJeuAchat hja3 = new HistoriqueJeuAchat(null, 1, null, ja5, jo1, null, true);
		HistoriqueJeuAchat hja4 = new HistoriqueJeuAchat(null, 3, null, ja7, jo1, null, true);
		HistoriqueJeuAchat hja5 = new HistoriqueJeuAchat(null, 4, null, ja9, jo1, null, true);
		HistoriqueJeuAchat hja6 = new HistoriqueJeuAchat(null, 4, null, ja11, jo1, null, false);
		Stream.of(hja1,hja2,hja3,hja4,hja5,hja6).forEach(hja -> histojeuachatRepo.save(hja));
	}

}
