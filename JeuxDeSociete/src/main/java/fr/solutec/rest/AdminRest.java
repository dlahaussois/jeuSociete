package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Admin;

import fr.solutec.entities.User;

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
	public Iterable<Admin> getAllAdmin(){
		return adminRepo.findAll();
	}
	

	

	
	@GetMapping("admin/id/{id}")
	public Optional<Admin> getAdminById(@PathVariable Long id){
		return adminRepo.findById(id);
	}
	
	@GetMapping("admin/login/{login}")
	public Optional<Admin> getAdminByLogin(@PathVariable String login){
		return adminRepo.findByUserLogin(login);
	}

	
	
}
