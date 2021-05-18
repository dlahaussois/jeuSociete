package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class User {
	@Id @GeneratedValue
	private Long id;
	private String login;
	private String password;
	private String mail;
	private String tel;
	private Boolean activity = true; // variable activité du compte (1 - OK/ 0 - bloqué)
}
