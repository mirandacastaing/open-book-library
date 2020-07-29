package com.cenfotec.examen2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cenfotec.examen2.domain.Guionista;
import com.cenfotec.examen2.service.GuionistaService;

@Controller
public class GuionistaController {
	@Autowired
	GuionistaService guionistaService;

	@GetMapping("/registroGuionista")
	public String guionistaForm(Model model) {
		model.addAttribute("guionista", new Guionista());
		model.addAttribute("guionistas", guionistaService.getAllGuionistas());

		return "registroGuionista";
	}

	@PostMapping("/")
	public String guionistaSubmit(@ModelAttribute Guionista guionista, Model model) {
		guionistaService.saveGuionista(guionista);

		return "index";
	}
}
