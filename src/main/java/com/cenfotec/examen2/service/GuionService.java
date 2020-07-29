package com.cenfotec.examen2.service;

import java.util.List;

import com.cenfotec.examen2.domain.Guion;

public interface GuionService {
	public void saveGuion(Guion newGuion);

	public List<Guion> getAllGuiones();

	public Guion findGuionById(String id);

	public List<Guion> findGuionesByObra(String obra);

	public List<Guion> findGuionesByGenero(String genero);

	public List<Guion> findGuionesByProduccion(boolean produccion);

	public List<Guion> findGuionesByObraAndGenero(String obra, String genero);

	public void deleteAllGuiones();
}
