package com.cenfotec.examen2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen2.domain.Guion;

public interface GuionRepository extends MongoRepository<Guion, String> {
	public Optional<Guion> findById(String word);

	public List<Guion> findByObraLike(String word);

	public List<Guion> findByGeneroLike(String word);

	public List<Guion> findByProduccion(Boolean word);
}
