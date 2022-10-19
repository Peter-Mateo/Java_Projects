package com.peterm.practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracticeController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "Peter Mateo");
		return "practice.jsp";
	}
}
