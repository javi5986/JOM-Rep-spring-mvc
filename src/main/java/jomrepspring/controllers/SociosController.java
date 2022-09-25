package jomrepspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jomrepspring.domain.Socios;
import jomrepspring.enums.SocioViewsEnum;
import jomrepspring.enums.SociosKeysEnum;
import jomrepspring.services.SociosService;

@Controller
@RequestMapping("/socio")
public class SociosController {

	//D.I
	@Autowired
	private SociosService sociosService;
	
	//http://localhost:8081/socio/all
	@GetMapping("/list")
	public String list(Model model) {

		List<Socios> socios = this.sociosService.buscarTodos();
		model.addAttribute("socios", socios);
		return SocioViewsEnum.LIST.getView();// "/socio/socios";
	}
	
	@GetMapping("/delete") 
	public String delete(
			@RequestParam(name="idSocio",required = true ) Long idSocios
			) {
		
		this.sociosService.eliminar(idSocios);
		
		return SocioViewsEnum.LIST_REDIRECT.getView();// "redirect:/socio/all";
	}
	
	@GetMapping("/edit/{id}") 
	public String preEdit(
			@PathVariable(name="id",required = true ) Long id,
			Model model
			) {
		
		Socios socios = this.sociosService.buscarSocio(id);
		
		model.addAttribute("SOCIO",socios);
		
		return SocioViewsEnum.EDIT.getView();//"edit";
	}

	@PostMapping("/edit")
	public String edit(
			@Validated
			@ModelAttribute(name = "SOCIO") Socios socio,
			BindingResult resul
			) {
		
		//verifico si hay errores
		if(resul.hasErrors()) {
			return SocioViewsEnum.NEW.getView();	
		}
		
		this.sociosService.crear(socio);
		
		return SocioViewsEnum.LIST_REDIRECT.getView();
	}
	
	@GetMapping("/new")
	public ModelAndView newCupon() {
		
		Socios entity = new Socios();
		
		ModelAndView model = new ModelAndView(SocioViewsEnum.NEW.getView());
		
		model.addObject(SociosKeysEnum.SOCIO.getKey(), entity);
		
		return model;
	}
	
	@PostMapping("/new")
	public String save(
			@Validated
			@ModelAttribute(name = "SOCIO") Socios cupon,
			BindingResult resul
			) {
		
		//verifico si hay errores
		if(resul.hasErrors()) {
			return SocioViewsEnum.NEW.getView();	
		}
		this.sociosService.crear(cupon);
		
		return SocioViewsEnum.LIST_REDIRECT.getView();
	}
}