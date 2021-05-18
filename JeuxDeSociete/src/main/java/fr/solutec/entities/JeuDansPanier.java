package fr.solutec.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JeuDansPanier {
	@Id @GeneratedValue
	private Long id;

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Jeu jeu;

	private int quantite;
}
