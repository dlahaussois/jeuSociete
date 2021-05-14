package fr.solutec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JeuxDeSocieteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JeuxDeSocieteApplication.class, args);
		
		
		System.out.println("Fin du programme");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test");
	}

}
