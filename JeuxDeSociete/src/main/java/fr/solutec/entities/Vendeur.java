package fr.solutec.entities;

import fr.solutec.entities.User;
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


public class Vendeur {
	
	@Id @GeneratedValue
	Long id;
	
	@OneToOne
	User user;
	

	
}
