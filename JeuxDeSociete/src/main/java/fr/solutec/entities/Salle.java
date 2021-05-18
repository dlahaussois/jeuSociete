package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Salle {

	@Id @GeneratedValue
	private Long id;
	private String nom;
	private double prix;
	private int nombreDePlaces;
	private boolean publique;
	private String urlImage;
}
