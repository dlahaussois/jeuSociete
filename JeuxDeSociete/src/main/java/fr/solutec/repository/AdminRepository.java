package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Admin;




public interface AdminRepository extends CrudRepository<Admin, Long>{
	public Optional<Admin> findByUserLogin(String login);
}
