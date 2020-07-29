package com.cenfotec.examen2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen2.domain.Guion;
import com.cenfotec.examen2.repository.GuionRepository;

@Service
public class GuionServiceImpl implements GuionService {
	@Autowired
	GuionRepository guionRepo;

	@Override
	public void saveGuion(Guion newGuion) {
		guionRepo.save(newGuion);
	}

	@Override
	public List<Guion> getAllGuiones() {
		return guionRepo.findAll();
	}

	@Override
	public Guion findGuionById(String id) {
		return guionRepo.findById(id).orElseGet(null);
	}

	@Override
	public List<Guion> findGuionesByObra(String obra) {
		return guionRepo.findByObraLike(obra);
	}

	@Override
	public List<Guion> findGuionesByGenero(String genero) {
		return guionRepo.findByGeneroLike(genero);
	}

	@Override
	public List<Guion> findGuionesByProduccion(boolean produccion) {
		return guionRepo.findByProduccion(produccion);
	}

	@Override
	public List<Guion> findGuionesByObraAndGenero(String obra, String genero) {
		List<Guion> guionesOriginales = findGuionesByObra(obra), guionesNuevos = new ArrayList<Guion>();

		for (Guion g : guionesOriginales) {
			if (g.getGenero().equals(genero)) {
				guionesNuevos.add(g);
			}
		}

		return guionesNuevos;
	}

	@Override
	public void deleteAllGuiones() {
		guionRepo.deleteAll();
	}
}
