package com.cenfotec.examen2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen2.domain.Actor;

public interface ActorRepository extends MongoRepository<Actor, String> {
	public List<Actor> findByNombreLike(String word);

	public List<Actor> findByGeneroLike(String genero1, String genero2);
}
