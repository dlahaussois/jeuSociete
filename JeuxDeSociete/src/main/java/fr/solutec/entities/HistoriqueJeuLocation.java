package fr.solutec.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class HistoriqueJeuLocation {
	@Id @GeneratedValue
	private Long id;
	
	private Date dateDebut;
	private Date dateFin;
	
	private int quantite;
	
	@CreationTimestamp 
    private Date dateCreation;
	
	@ManyToOne
	private JeuLocation jeuLocation;
	
	@ManyToOne
	private Joueur joueur;
	
	@ManyToOne
	private Vendeur vendeur;
	
	private boolean effectue;
}
