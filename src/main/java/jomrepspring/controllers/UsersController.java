package jomrepspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jomrepspring.domain.Users;
import jomrepspring.services.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService us;
	
	@GetMapping("/all")
	public String allUser () {
		List<Users> users = this.us.buscarTodos();
		
		System.out.println(users);
		return "home";
	}
}
