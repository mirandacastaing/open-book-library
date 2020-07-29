package com.cenfotec.examen2.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen2.domain.Actor;
import com.cenfotec.examen2.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	ActorRepository actorRepo;

	@Override
	public void saveActor(Actor newActor) {
		actorRepo.save(newActor);
	}

	@Override
	public List<Actor> getAllActores() {
		return actorRepo.findAll();
	}

	@Override
	public Actor findActorById(String id) {
		return actorRepo.findById(id).orElseGet(null);
	}

	@Override
	public List<Actor> findActoresByNombre(String nombre) {
		return actorRepo.findByNombreLike(nombre);
	}

	@Override
	public List<Actor> findActoresByGenero(String genero) {
		return actorRepo.findByGeneroLike(genero, "O");
	}

	@Override
	public List<Actor> findActoresByRangoEdades(int edadMinima, int edadMaxima) {
		List<Actor> actoresOriginales = getAllActores(), actoresNuevos = new ArrayList<Actor>();
		LocalDate fechaActual = LocalDate.now();
		int edad;

		for (Actor a : actoresOriginales) {
			edad = Period
					.between(a.getNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), fechaActual)
					.getYears();

			if (edadMinima != 0 && edadMaxima != 0) {
				if (edad >= edadMinima && edad <= edadMaxima)
					actoresNuevos.add(a);
			} else if (edadMinima != 0) {
				if (edad >= edadMinima)
					actoresNuevos.add(a);
			} else {
				if (edad <= edadMaxima)
					actoresNuevos.add(a);
			}
		}

		return actoresNuevos;
	}

	@Override
	public List<Actor> findActoresByNombreAndRangoEdades(String nombre, int edadMinima, int edadMaxima) {
		List<Actor> actoresOriginales = findActoresByNombre(nombre), actoresNuevos = new ArrayList<Actor>();
		LocalDate fechaActual = LocalDate.now();
		int edad;

		for (Actor a : actoresOriginales) {
			edad = Period
					.between(a.getNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), fechaActual)
					.getYears();

			if (edadMinima != 0 && edadMaxima != 0) {
				if (edad >= edadMinima && edad <= edadMaxima)
					actoresNuevos.add(a);
			} else if (edadMinima != 0) {
				if (edad >= edadMinima)
					actoresNuevos.add(a);
			} else {
				if (edad <= edadMaxima)
					actoresNuevos.add(a);
			}
		}

		return actoresNuevos;
	}

	@Override
	public void deleteAllActores() {
		actorRepo.deleteAll();
	}
}
