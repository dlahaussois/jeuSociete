package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Admin;
import fr.solutec.entities.JeuAchat;
import fr.solutec.entities.User;
import fr.solutec.entities.Vendeur;
import fr.solutec.repository.AdminRepository;

import fr.solutec.repository.UserRepository;


@RestController @CrossOrigin("*")
public class AdminRest {

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	//Creation admin depuis infos user
	@PostMapping("admin/save")
	public Admin addAdmin(@RequestBody User u) {
		User u1 = userRepo.save(u);
		Admin ad = new Admin(null, u1);
		return adminRepo.save(ad);
		
	}
	
	
	@GetMapping("admin/list")
	public  Iterable<Admin> getAllAdmin(){
		return adminRepo.findAll();
	}
	
	@PostMapping("admin/recherche")
	public  Optional<Admin> rechercheadminByLogin(@RequestBody User u){
		return adminRepo.findByUserLogin(u.getLogin() );
	}
	

	
	@GetMapping("admin/id/{id}")
	public Optional<Admin> getAdminById(@PathVariable Long id){
		return adminRepo.findById(id);
	}
	
	@GetMapping("admin/login/{login}")
	public Optional<Admin> getAdminByLogin(@PathVariable String login){
		return adminRepo.findByUserLogin(login);
	}

	@PutMapping("admin/modifier")
	public Admin modifierAdmin(@RequestBody Admin a) {
		userRepo.save(a.getUser());
		return adminRepo.save(a);
	}
	
	@PutMapping("admin/bloquer")
	public  Admin bloquerAdmin(@RequestBody Admin v){
		
		System.out.println(v);
		boolean a = v.getUser().getActivity();
		
		if (a == true ) {
			v.getUser().setActivity(false);
			
		} else {
			v.getUser().setActivity(true);
			
		}
		System.out.println(v);
		
		userRepo.save(v.getUser());
		
		return adminRepo.save(v);
	}
	
	@DeleteMapping("admin/supprimer}")
	public boolean suppPerson(@RequestBody Admin u) {
		
		
			
		System.out.println("in suppri");
		if (adminRepo.findById(u.getId()).isPresent()) {
			System.out.println("in boucle suppri");
			adminRepo.delete(u);
			userRepo.delete(u.getUser());
			
			
			return true;
		}
		else {
			System.out.println("no suppri");
			return false;
		}

			
	}
}
