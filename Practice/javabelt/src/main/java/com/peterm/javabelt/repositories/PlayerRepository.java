package com.peterm.javabelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.peterm.javabelt.models.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
	// Grabs it all
	List<Player> findAll();
	
}
