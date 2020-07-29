package com.cenfotec.examen2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cenfotec.examen2.domain.Actor;
import com.cenfotec.examen2.domain.Guion;

@Controller
public class Examen2Controller {
	@GetMapping("/")
	public String produccionesPomponioInfo(Model model) {
		model.addAttribute("tmpGuion", new Guion());
		model.addAttribute("tmpActor", new Actor());

		return "index";
	}
}
