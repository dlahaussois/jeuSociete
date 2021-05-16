package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class JeuLocation {
	
	@Id @GeneratedValue
	private Long id;
	
	private double prixLocation;
		
	@OneToOne
	private Jeu lejeu;
	
	

	
}
