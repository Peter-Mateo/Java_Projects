package com.peterm.javabelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.peterm.javabelt.models.Team;


@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	List<Team> findAll();
}
