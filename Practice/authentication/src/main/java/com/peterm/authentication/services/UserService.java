package com.peterm.authentication.services;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.peterm.authentication.models.LoginUser;
import com.peterm.authentication.models.User;
import com.peterm.authentication.repositories.UserRepository;
    

    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // Register and Login Methods
    public User register(User newUser, BindingResult result) {
    	// GETs the email
    	String emailEntered = newUser.getEmail();
    	// Checks to see if the email is already in the DB
    	Optional<User> checkEmail = userRepo.findByEmail(emailEntered);
    	if(checkEmail.isPresent()) {
    		result.rejectValue("email", "Invalid", "This Email already exsists!");
    	}
    	// Checks to see if PSWD and CPSWD match
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
        // Checks to see if it is properly filled out
		if(result.hasErrors()) {
			return null;
		} 
		// Hash PSWD Set PSWD
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		// Save User to DB
		userRepo.save(newUser);
		
        return newUser;
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        // Checks to See if the email is in the DB
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if(potentialUser.isPresent()) {
    		// Gets the User info
    		User user = potentialUser.get();
    		// Checks to see if the PSWD matches the one in the database
    		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		    result.rejectValue("password", "Matches", "Invalid Password!");
    		} else {
    			return user;
    		}
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
        return null;
    }
}