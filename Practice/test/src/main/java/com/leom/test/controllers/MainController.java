package com.peterm.test.controllers;

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

import com.peterm.test.models.LoginUser;
import com.peterm.test.models.Show;
import com.peterm.test.models.User;
import com.peterm.test.services.ShowService;
import com.peterm.test.services.UserService;


@Controller
public class MainController {
	@Autowired
	private ShowService showServ;
	
	@Autowired
	private UserService userServ;

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
    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/home";
    }
    // Home
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
    	// Checks if the User is logged in
    	if(null == session.getAttribute("user")) {
    		return "redirect:/";
    	}
    	model.addAttribute("shows", showServ.all());
    	// Adds the JSP
    	model.addAttribute(session);
    
    	return "home.jsp";
    }
    // New Show
    @GetMapping("/shows/new")
    public String newShow(Model model) {
    	model.addAttribute("newShow", new Show());
    	return "new.jsp";
    }
    // New Show POST
    @PostMapping("/shows")
    public String create(@Valid @ModelAttribute("newShow") Show show, BindingResult result) {
    	if(result.hasErrors()) {
    		return "new.jsp";
    	}
    	showServ.register(show, result);
    	return "redirect:/home";
    }
    // Show
    @GetMapping("/shows/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Show show = showServ.findShow(id);
    	model.addAttribute("show", show);
    	return "show.jsp";
    }
    // Edit 
    @GetMapping("/shows/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
    	Show show = showServ.findShow(id);
    	model.addAttribute("edshow", show);
    	return "edit.jsp";
    }
    @PostMapping("/shows/update/{id}")
    public String update(@Valid @ModelAttribute("edshow") Show show, BindingResult result) {
    	if (result.hasErrors()) {
            return "/shows/new.jsp";
        } else {
        	showServ.update(show, result);
        	return "redirect:/home";
        }
    }
    // Delete
    @DeleteMapping("shows/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	showServ.deleteShow(id);
    	return "redirect:/home";
    }
    
    
    
}