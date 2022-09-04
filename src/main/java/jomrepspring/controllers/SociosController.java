package jomrepspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jomrepspring.domain.Socios;
import jomrepspring.services.SociosService;

@Controller
@RequestMapping("/socio")
public class SociosController {

	//D.I
	@Autowired
	private SociosService sociosService;
	
	//http://localhost:8081/socio/all
	@GetMapping("/all")
	public String all(Model model) {
		List<Socios> socios = this.sociosService.buscarTodos();
		model.addAttribute("socios", socios);
		return "socios";
	}
}