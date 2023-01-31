package com.peterm.javabelt.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.peterm.javabelt.models.Team;
import com.peterm.javabelt.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepo;
	
	// Register New Team
	public Team register(Team newTeam, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		// Save New Team
		teamRepo.save(newTeam);
		return newTeam;
	}
	// Edit the Team
	public Team update(Team edTeam, BindingResult result) {
		// Finds the team
		Long teams = edTeam.getId();
		Optional<Team> opTeam = teamRepo.findById(teams);
		// Update
		if(opTeam.isPresent()) {
			Team team = opTeam.get();
			team.setTeamName(edTeam.getTeamName());
			team.setSkillLevel(edTeam.getSkillLevel());
			team.setGameDay(edTeam.getGameDay());
			// Updates Team
			teamRepo.save(team);
			return team;
		} else {
			return null;
		}
	}
	// Retrieves Specific Team
	public Team findTeam(Long id) {
		Optional<Team> optionalTeam = teamRepo.findById(id);
		if(optionalTeam.isPresent()) {
			return optionalTeam.get();
		} else {
			return null;
		}
	}
	// Grabs Team info
	public List<Team> all() {
		List<Team> teams = teamRepo.findAll();
		return teams;
	}
	// Delete
	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}
	
	
}
