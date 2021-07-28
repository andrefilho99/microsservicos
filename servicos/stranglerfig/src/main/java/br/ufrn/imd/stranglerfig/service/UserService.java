package br.ufrn.imd.stranglerfig.service;

import org.springframework.stereotype.Service;

import br.ufrn.imd.stranglerfig.model.LoginForm;
import br.ufrn.imd.stranglerfig.model.User;

@Service
public class UserService {

	public Object findOne(String email) {
		
		//Request user from API
		return null;
	}
	
	public Object login(LoginForm loginForm) {
		
		//Request jwtResponse from API
		return null;
	}
	
	public Object save(User user) {
		
		//Post user to API
		return null;
	}

	public Object update(User user) {
		
		//Update user to API
		return null;
	}
}
