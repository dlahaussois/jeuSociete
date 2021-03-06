package fr.solutec.entities;

import javax.persistence.Column;
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
	private int NombreJoueursMin;
	private int NombreJoueursMax;
	private int AgeMin;
	private String NiveauDifficulte;
	private int TempsDeJeu;
	@Column(length = 10000)
	private String Description;
	@Column(length = 10000)
	private String RegleDuJeu;
	private String urlImage;
	private double prixLocation;
	
	@ManyToOne
	private Categorie categorieDuJeu;
	
	@ManyToOne
	private Marque marqueDuJeu;

	
}
