package com.peterm.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {

	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String firstName, @RequestParam(value="last_name", required=false)String lastName, @RequestParam(value="times")int times) {
		// Checks to see if there is a first and last name
		if (firstName != null) {
			if (lastName != null) {
				return "Hello " + firstName + " " + lastName;
			}
			return "Hello " + firstName;
		}
		else {
			return "Hello Human";
		}
	}
}
