package com.peterm.javabelt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.peterm.javabelt.models.LoginUser;
import com.peterm.javabelt.models.Player;
import com.peterm.javabelt.models.Team;
import com.peterm.javabelt.models.User;
import com.peterm.javabelt.services.PlayerService;
import com.peterm.javabelt.services.TeamService;
import com.peterm.javabelt.services.UserService;


@Controller
public class MainController {
    @Autowired
    private PlayerService playerServ;

	@Autowired
	private UserService userServ;

	@Autowired
	private TeamService teamServ;
	
    // POST Register
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        // Extra Validations
        User user = userServ.register(newUser, result);
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        // Logs in
        session.setAttribute("user", user);
        return "redirect:/home";
    }
    // POST User Login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        

        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        // Logs in
        session.setAttribute("user", user);
        return "redirect:/home";
    }
    // Login Page
    @GetMapping("/")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    // New Team
    @GetMapping("/teams/new")
    public String newTeam(Model model) {
    	model.addAttribute("newTeam", new Team());
    	return "new.jsp";
    }
    
    // New Team POST
    @PostMapping("/teams")
    public String create(@Valid @ModelAttribute("team") Team team, BindingResult result) {
    	if(result.hasErrors()) {
    		return "new.jsp";
    	}
    	teamServ.register(team, result);
    	return "redirect:/home";
    }
    // Home
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
    	// Checks if the User is logged in
    	if(null == session.getAttribute("user")) {
    		return "redirect:/";
    	}
    	model.addAttribute("teams", teamServ.all());
    	// Adds the JSP
    	model.addAttribute(session);
    
    	return "home.jsp";
    }
    // Edit 
    @GetMapping("/teams/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
    	Team team = teamServ.findTeam(id);
    	model.addAttribute("edTeam", team);
    	return "edit.jsp";
    }
    @PostMapping("/teams/update/{id}")
    public String update(@Valid @ModelAttribute("edteam") Team team, BindingResult result) {
    	if (result.hasErrors()) {
            return "/teams/new.jsp";
        } else {
        	teamServ.update(team, result);
        	return "redirect:/home";
        }
    }
    // Delete
    @DeleteMapping("teams/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	teamServ.deleteTeam(id);
    	return "redirect:/home";
    }
    // Show
    @GetMapping("/teams/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Team team = teamServ.findTeam(id);
    	Player player = new Player();
    	model.addAttribute("team", team);
    	model.addAttribute("player", player);
    	return "show.jsp";
    }
    // Post New player
    @PostMapping("/teams/add/player/{team}/{user}/")
    public String addPlayer(@PathVariable("team")Team team, @PathVariable("user") User user, @ModelAttribute("player") Player player, BindingResult result) {
    	if(result.hasErrors()) {
    		return "show.jsp";
    	} else {
    		playerServ.newAdd(team, user, player);
    		return "redirect:/home";
    	}
    }
    
    
    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/home";
    }
}