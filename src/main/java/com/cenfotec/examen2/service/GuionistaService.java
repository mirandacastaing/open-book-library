package com.cenfotec.examen2.service;

import java.util.List;

import com.cenfotec.examen2.domain.Guionista;

public interface GuionistaService {
	public void saveGuionista(Guionista newGuionista);

	public List<Guionista> getAllGuionistas();

	public Guionista findGuionistaById(String id);

	public List<Guionista> findGuionistasByNombre(String nombre);

	public void deleteAllGuionistas();
}
