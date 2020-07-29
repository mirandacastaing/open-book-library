package com.cenfotec.examen2.service;

import java.util.List;

import com.cenfotec.examen2.domain.Actor;

public interface ActorService {
	public void saveActor(Actor newActor);

	public List<Actor> getAllActores();

	public Actor findActorById(String id);

	public List<Actor> findActoresByNombre(String nombre);

	public List<Actor> findActoresByRangoEdades(int edadMinima, int edadMaxima);

	public List<Actor> findActoresByNombreAndRangoEdades(String nombre, int edadMinima, int edadMaxima);

	public List<Actor> findActoresByGenero(String genero);

	public void deleteAllActores();
}
