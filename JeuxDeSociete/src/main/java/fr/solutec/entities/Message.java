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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Message {
	@Id @GeneratedValue
	private Long id;
	@CreationTimestamp 
    private Date dateCreation;
	
	private String contenu;
	
	
	
	@ManyToOne
	private User expediteur;
	
	@ManyToOne
	private User destinataire;
	@ManyToOne
	private Forum forum;
	private boolean privee;//on défini les messages privés par défaut
}
