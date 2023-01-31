package com.peterm.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.peterm.authentication.models.LoginUser;
import com.peterm.authentication.models.User;
import com.peterm.authentication.services.UserService;

@Controller
public class HomeController {
    
	@Autowired
	private UserService userServ;    
    // Register
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
    // User Login
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
    // Home Page
    @GetMapping("/")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
    	// Checks if the User is logged in
    	if(null == session.getAttribute("user")) {
    		return "redirect:/";
    	}
    	model.addAttribute(session);
    	return "home.jsp";
    }
    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/home";
    }
}
