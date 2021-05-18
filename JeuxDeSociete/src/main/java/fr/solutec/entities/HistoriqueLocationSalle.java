package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class HistoriqueLocationSalle {
	@Id @GeneratedValue
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private boolean locationValidee;
	
	@OneToOne
	private Salle salle;
	@ManyToOne
	private Joueur joueur;
	@ManyToOne
	private Vendeur vendeur;
	@OneToOne
	private Joueur joueurMaitreSalle;
	
}
