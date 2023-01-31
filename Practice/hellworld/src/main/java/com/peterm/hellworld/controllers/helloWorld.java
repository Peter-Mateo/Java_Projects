package com.peterm.hellworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class helloWorld {
		@GetMapping("/")
		public String index(HttpSession session) {
			return "helloworld.jsp";
		}
		@GetMapping("/back")
		public String back() {
			return "redirect:/";
		}
		@GetMapping("/results")
		public String results(Model model, HttpSession session) {
			//Sets
			Integer choice = (Integer) session.getAttribute("numChoice");
			String city = (String) session.getAttribute("city");
			String person = (String) session.getAttribute("person");
			String profession = (String) session.getAttribute("profession");
			String livingT = (String) session.getAttribute("livingT");
			String comment = (String) session.getAttribute("comment");
			//
			model.addAttribute("choice", choice);
			model.addAttribute("city", city);
			model.addAttribute("person", person);
			model.addAttribute("profession", profession);
			model.addAttribute("livingT", livingT);
			model.addAttribute("comment", comment);
			return "results.jsp";
		}
		@PostMapping("/login")
		public String login(
				@RequestParam(value="numChoice") int numChoice,
				@RequestParam(value="city") String city,
				@RequestParam(value="person") String person,
				@RequestParam(value="profession") String profession,
				@RequestParam(value="livingT") String livingT,
				@RequestParam(value="comment") String comment, HttpSession session){
			session.setAttribute("numChoice", numChoice);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("profession", profession);
			session.setAttribute("livingT", livingT);
			session.setAttribute("comment", comment);
			return "redirect:/results";
		}	
}
