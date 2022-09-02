package jomrepspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// GET http://localhost:8080
	@GetMapping(value = "/")
	public String home() {
		
		return "home";
		// quiero ir a la pag home.html
	}
	
	public void doNada() {
		
	}
}
