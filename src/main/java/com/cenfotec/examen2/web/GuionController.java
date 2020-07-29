package com.cenfotec.examen2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cenfotec.examen2.domain.Actor;
import com.cenfotec.examen2.domain.Guion;
import com.cenfotec.examen2.service.ActorService;
import com.cenfotec.examen2.service.GuionService;
import com.cenfotec.examen2.service.GuionistaService;

@Controller
public class GuionController {
	@Autowired
	GuionService guionService;
	@Autowired
	GuionistaService guionistaService;
	@Autowired
	ActorService actorService;

	@GetMapping("/registroGuion")
	public String guionForm(Model model) {
		model.addAttribute("guion", new Guion());
		model.addAttribute("guionistas", guionistaService.getAllGuionistas());
		model.addAttribute("tmpGuion", new Guion());

		return "registroGuion";
	}

	@PostMapping("/listaGuiones")
	public String guionSubmit(@ModelAttribute Guion guion, @ModelAttribute Guion tmpGuion, Model model) {
		if (guion.getId() != null) {
			tmpGuion.setGenero(guion.getGenero());
			tmpGuion.setObra(guion.getObra());

			guion = guionService.findGuionById(guion.getId());

			if (guion.getProduccion()) {
				guion.setProduccion(false);
				guion.setActorPrincipal(new Actor());
				guion.setActrizPrincipal(new Actor());
			} else
				guion.setProduccion(true);
		} else
			tmpGuion = new Guion();

		guionService.saveGuion(guion);

		return guionList(tmpGuion, model);
	}

	@GetMapping("/listaGuiones")
	public String guionList(@ModelAttribute Guion tmpGuion, Model model) {
		List<Guion> guiones;

		if (tmpGuion.getGenero() != null && tmpGuion.getObra() != null)
			if (!tmpGuion.getGenero().equals("") && !tmpGuion.getObra().equals(""))
				guiones = guionService.findGuionesByObraAndGenero(tmpGuion.getObra(), tmpGuion.getGenero());
			else if (!tmpGuion.getGenero().equals(""))
				guiones = guionService.findGuionesByGenero(tmpGuion.getGenero());
			else
				guiones = guionService.findGuionesByObra(tmpGuion.getObra());
		else
			guiones = guionService.getAllGuiones();

		for (Guion g : guiones) {
			g.setScreenwriter(guionistaService.findGuionistaById(g.getScreenwriter().getId()));

			switch (g.getGenero()) {
			case "TR":
				g.setGenero("Tragedia");
				break;
			case "CO":
				g.setGenero("Comedia");
				break;
			case "CU":
				g.setGenero("Culebrón");
				break;
			case "FA":
				g.setGenero("Fantasía");
				break;
			default:
				break;
			}

			if (g.getActorPrincipal().getId() != null)
				g.setActorPrincipal(actorService.findActorById(g.getActorPrincipal().getId()));
			else
				g.getActorPrincipal().setNombre("No asignado");

			if (g.getActrizPrincipal().getId() != null)
				g.setActrizPrincipal(actorService.findActorById(g.getActrizPrincipal().getId()));
			else
				g.getActrizPrincipal().setNombre("No asignada");
		}

		model.addAttribute("guiones", guiones);
		model.addAttribute("opcionesListaGuiones", tmpGuion);
		model.addAttribute("tmpGuion", tmpGuion);
		model.addAttribute("guion", new Guion());

		return "listaGuiones";
	}

	@GetMapping("/listaGuionesProduccion")
	public String guionProduccionList(Model model) {
		List<Guion> guiones = guionService.findGuionesByProduccion(true);

		for (Guion g : guiones) {
			g.setScreenwriter(guionistaService.findGuionistaById(g.getScreenwriter().getId()));

			switch (g.getGenero()) {
			case "TR":
				g.setGenero("Tragedia");
				break;
			case "CO":
				g.setGenero("Comedia");
				break;
			case "CU":
				g.setGenero("Culebrón");
				break;
			case "FA":
				g.setGenero("Fantasía");
				break;
			default:
				break;
			}

			if (g.getActorPrincipal().getId() != null)
				g.setActorPrincipal(actorService.findActorById(g.getActorPrincipal().getId()));
			else
				g.getActorPrincipal().setNombre("No asignado");

			if (g.getActrizPrincipal().getId() != null)
				g.setActrizPrincipal(actorService.findActorById(g.getActrizPrincipal().getId()));
			else
				g.getActrizPrincipal().setNombre("No asignada");
		}

		model.addAttribute("guiones", guiones);

		return "listaGuionesProduccion";
	}

	@PostMapping("/asignacionActores")
	public String actorAssignmentForm(@ModelAttribute Guion guion, Model model) {
		guion = guionService.findGuionById(guion.getId());

		model.addAttribute("prueba", guion.getActorPrincipal());

		model.addAttribute("guion", guion);
		model.addAttribute("actores", actorService.findActoresByGenero("H"));
		model.addAttribute("actrices", actorService.findActoresByGenero("M"));

		return "asignacionActores";
	}

	@PostMapping("/listaGuionesProduccion")
	public String actorAssignment(@ModelAttribute Guion guion, Model model) {
		Actor actorPrincipal = guion.getActorPrincipal(), actrizPrincipal = guion.getActrizPrincipal();

		guion = guionService.findGuionById(guion.getId());

		guion.setActorPrincipal(actorPrincipal);
		guion.setActrizPrincipal(actrizPrincipal);

		guionService.saveGuion(guion);

		return guionProduccionList(model);
	}
}
