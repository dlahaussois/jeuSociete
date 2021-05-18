package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Avis {
	@Id @GeneratedValue
	private Long id;
	private String note;
	private String commentaire;
	
	@OneToOne
	private User user;
	
	@ManyToOne
	private Jeu jeu;
	
	
}
