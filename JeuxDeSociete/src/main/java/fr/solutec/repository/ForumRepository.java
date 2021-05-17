package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Forum;

public interface ForumRepository extends CrudRepository<Forum, Long>{

}
