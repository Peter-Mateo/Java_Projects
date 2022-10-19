package com.peterm.daikichi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/daikichi")
public class DaikichiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiApplication.class, args);
	}
	@RequestMapping("/travel/{destination}")
	public String travel(@PathVariable("destination") String destination) {
		return "Congratulations! You will soon travel to " + destination + "!";
	}
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number")int number) {
		if (number % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
}
