package fr.solutec.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Jeu {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private int NombreJoueurs;
	private int AgeMin;
	private String NiveauDifficulte;
	private Date TempsDeJeu;
	private String Description;
	private String RegleDuJeu;
	
	@ManyToOne
	private Categorie categorie;
	
	@ManyToOne
	private Marque marque;
}
