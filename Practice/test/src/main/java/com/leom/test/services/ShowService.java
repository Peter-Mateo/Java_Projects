package com.leom.test.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.leom.test.models.Show;
import com.leom.test.repositories.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepo;
	
	// Register New Show
	public Show register(Show newShow, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		// Save New Show
		showRepo.save(newShow);
		return newShow;
	}
	// Edit the Show
	public Show update(Show edShow, BindingResult result) {
		// Finds the Show
		Long shows = edShow.getId();
		Optional<Show> opShow = showRepo.findById(shows);
		// Update
		if(opShow.isPresent()) {
			Show show = opShow.get();
			show.setTitle(edShow.getTitle());
			show.setNetwork(edShow.getNetwork());
			show.setDescription(edShow.getDescription());
			// Updates Team
			showRepo.save(show);
			return show;
		} else {
			return null;
		}
	}
	// Retrieves Specific Show
	public Show findShow(Long id) {
		Optional<Show> optionalShow = showRepo.findById(id);
		if(optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	// Grabs Show info
	public List<Show> all() {
		List<Show> shows = showRepo.findAll();
		System.out.println(shows);
		return shows;
	}
	// Delete
	public void deleteShow(Long id) {
		showRepo.deleteById(id);
	}
	
	
}
