package com.cenfotec.examen2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cenfotec.examen2.domain.Actor;
import com.cenfotec.examen2.service.ActorService;

@Controller
public class ActorController {
	@Autowired
	ActorService actorService;

	@GetMapping("/registroActor")
	public String actorForm(Model model) {
		model.addAttribute("actor", new Actor());
		model.addAttribute("tmpActor", new Actor());

		return "registroActor";
	}

	@PostMapping("/listaActores")
	public String actorSubmit(@ModelAttribute Actor actor, @ModelAttribute Actor tmpActor, Model model) {
		actorService.saveActor(actor);

		return actorList(tmpActor, model);
	}

	@GetMapping("/listaActores")
	public String actorList(@ModelAttribute Actor tmpActor, Model model) {
		List<Actor> actores;
		String terminacion = "";

		if (tmpActor.getNombre() != null && tmpActor.getEdadMaxima() != null && tmpActor.getEdadMaxima() != null)
			if (!tmpActor.getNombre().equals("")
					&& ((!tmpActor.getEdadMinima().equals("") && !tmpActor.getEdadMinima().equals("0"))
							|| !tmpActor.getEdadMaxima().equals(""))) {
				boolean edadMinima = false, edadMaxima = false;

				if (tmpActor.getEdadMinima().equals("")) {
					tmpActor.setEdadMinima("0");
					edadMinima = true;
				}

				if (tmpActor.getEdadMaxima().equals("")) {
					tmpActor.setEdadMaxima("0");
					edadMaxima = true;
				}

				if (!edadMinima && edadMaxima && (int) (Math.round(Double.parseDouble(tmpActor.getEdadMinima()))) == 0)
					actores = actorService.findActoresByNombreAndRangoEdades(tmpActor.getNombre(), 0, 125);
				else if (!edadMaxima && (int) (Math.round(Double.parseDouble(tmpActor.getEdadMaxima()))) == 0)
					actores = actorService.findActoresByNombreAndRangoEdades(tmpActor.getNombre(),
							(int) (Math.round(Double.parseDouble(tmpActor.getEdadMinima()))), -1);
				else
					actores = actorService.findActoresByNombreAndRangoEdades(tmpActor.getNombre(),
							(int) (Math.round(Double.parseDouble(tmpActor.getEdadMinima()))),
							(int) (Math.round(Double.parseDouble(tmpActor.getEdadMaxima()))));

				if (edadMinima)
					tmpActor.setEdadMinima("");

				if (edadMaxima)
					tmpActor.setEdadMaxima("");
			} else if (!tmpActor.getEdadMinima().equals("") || !tmpActor.getEdadMaxima().equals("")) {
				boolean edadMinima = false, edadMaxima = false;

				if (tmpActor.getEdadMinima().equals("")) {
					tmpActor.setEdadMinima("0");
					edadMinima = true;
				}

				if (tmpActor.getEdadMaxima().equals("")) {
					tmpActor.setEdadMaxima("0");
					edadMaxima = true;
				}

				if (!edadMinima && edadMaxima && (int) (Math.round(Double.parseDouble(tmpActor.getEdadMinima()))) == 0)
					actores = actorService.findActoresByNombreAndRangoEdades(tmpActor.getNombre(), 0, 125);
				else if (!edadMaxima && (int) (Math.round(Double.parseDouble(tmpActor.getEdadMaxima()))) == 0)
					actores = actorService.findActoresByNombreAndRangoEdades(tmpActor.getNombre(),
							(int) (Math.round(Double.parseDouble(tmpActor.getEdadMinima()))), -1);
				else
					actores = actorService.findActoresByNombreAndRangoEdades(tmpActor.getNombre(),
							(int) (Math.round(Double.parseDouble(tmpActor.getEdadMinima()))),
							(int) (Math.round(Double.parseDouble(tmpActor.getEdadMaxima()))));

				if (edadMinima)
					tmpActor.setEdadMinima("");

				if (edadMaxima)
					tmpActor.setEdadMaxima("");
			} else
				actores = actorService.findActoresByNombre(tmpActor.getNombre());
		else
			actores = actorService.getAllActores();

		for (Actor a : actores) {
			switch (a.getGenero()) {
			case "H":
				a.setGenero("Hombre");
				terminacion = "o";
				break;
			case "M":
				a.setGenero("Mujer");
				terminacion = "a";
				break;
			case "O":
				a.setGenero("Otro");
				break;
			default:
				break;
			}

			switch (a.getComplexion()) {
			case "F":
				if (!a.getGenero().equals("Otro"))
					a.setComplexion("Flac" + terminacion);
				else
					a.setComplexion("Flaco/a");
				break;
			case "R":
				a.setComplexion("Regular");
				break;
			case "G":
				if (!a.getGenero().equals("Otro"))
					a.setComplexion("Grues" + terminacion);
				else
					a.setComplexion("Grueso/a");
				break;
			default:
				break;
			}

			a.setOjos(a.getOjos().toLowerCase());
			a.setPelo(a.getPelo().toLowerCase());
		}

		model.addAttribute("actores", actores);
		model.addAttribute("tmpActor", tmpActor);

		return "listaActores";
	}
}
