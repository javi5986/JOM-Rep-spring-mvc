package jomrepspring.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jomrepspring.domain.Cupon;
import jomrepspring.domain.CuponViewsEnum;
import jomrepspring.services.CuponService;


@Controller
@RequestMapping("/cupon")
public class CuponesController {

	@Autowired
	private CuponService cuponService;
	
	@GetMapping("/list")
	public String list(Model model) {

		Set<Cupon> cupones = new HashSet<>(this.cuponService.buscarTodos());// this.cuponService.buscarTodos().stream().collect(Collectors.toSet());

		model.addAttribute("CUPONES", cupones);

		return CuponViewsEnum.LIST.getView();
	}

}