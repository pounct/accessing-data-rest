package com.example.jocdedaus.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.jocdedaus.model.domain.Tirada;

@RepositoryRestResource(collectionResourceRel = "tirada", path = "tirada")
public interface TiradaRepository extends JpaRepository<Tirada, Long>{

	List<Tirada> findAllByPlayerId(Long playerId);
	void deleteAllByPlayerId(Long playerId);
}
