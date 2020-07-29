package com.cenfotec.examen2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen2.domain.Guionista;

public interface GuionistaRepository extends MongoRepository<Guionista, String> {
	public List<Guionista> findByNombreLike(String word);
}
