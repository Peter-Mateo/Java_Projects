package com.peterm.javabelt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peterm.javabelt.models.Player;
import com.peterm.javabelt.models.Team;
import com.peterm.javabelt.models.User;
import com.peterm.javabelt.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerRepo;
	
	//Register a new player
	public Player newAdd(Team team, User user, Player player_name) {
		Player newPlayer = new Player();
		newPlayer.setPlayerName(player_name.getPlayerName());
		newPlayer.setTeam(team);
		newPlayer.setUser(user);
		playerRepo.save(newPlayer);
		return newPlayer;
	}
}
