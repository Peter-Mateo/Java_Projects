package com.peterm.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayDate {
	
	// Index Page
	@GetMapping("/")
	String index() {
		return "index.jsp";
	}
	// Date Page
	@GetMapping("/date")
	String date() {
		return "date.jsp";
	}
	// Time Page
	@GetMapping("/time")
	String time() {
		return "time.jsp";
	}
}
