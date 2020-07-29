package com.cenfotec.examen2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen2.domain.Guionista;
import com.cenfotec.examen2.repository.GuionistaRepository;

@Service
public class GuionistaServiceImpl implements GuionistaService {
	@Autowired
	GuionistaRepository guionistaRepo;

	@Override
	public void saveGuionista(Guionista newGuionista) {
		guionistaRepo.save(newGuionista);
	}

	@Override
	public List<Guionista> getAllGuionistas() {
		return guionistaRepo.findAll();
	}

	@Override
	public Guionista findGuionistaById(String id) {
		Optional<Guionista> guionista = guionistaRepo.findById(id);

		if (guionista.isPresent())
			return guionista.get();
		else {
			Guionista tmpGuionista = new Guionista();

			tmpGuionista.setId(id);
			tmpGuionista.setNombre("Guionista no identificado");

			return tmpGuionista;
		}
	}

	@Override
	public List<Guionista> findGuionistasByNombre(String nombre) {
		return guionistaRepo.findByNombreLike(nombre);
	}

	@Override
	public void deleteAllGuionistas() {
		guionistaRepo.deleteAll();
	}
}
