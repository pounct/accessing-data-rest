package com.example.jocdedaus.model.services;

import java.util.List;

import com.example.jocdedaus.model.domain.Player;
import com.example.jocdedaus.model.domain.Tirada;
import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.dto.TiradaDTO;

//import reactor.core.publisher.Flux;

public interface IPlayerService {
	void addPlayer(Player player);
	void updatePlayer(Player player);
	void addTirada(Long id, Tirada tirada);
	void deleteTirades(Long id);
	List<PlayerDTO> getAllPlayers();
	List<TiradaDTO> getAllTirades(Long id);
	Double getPercentatgeMitja();
	Double getPercentatgeMitjaMitjor();
	Double getPercentatgeMitjaPitjor();
	/*
	 * URL’s: 
POST: /players: crea un jugador/a. 
PUT /players: modifica el nom del jugador/a.
POST /players/{id}/games/ : un jugador/a específic realitza una tirada dels daus.  
DELETE /players/{id}/games: elimina les tirades del jugador/a.
GET /players/: retorna el llistat de tots  els jugadors/es del sistema amb el seu  percentatge mitjà d’èxits.   
GET /players/{id}/games: retorna el llistat de jugades per un jugador/a.  
GET /players/ranking: retorna el ranking mig de tots els jugadors/es del sistema. És a dir, el  percentatge mitjà d’èxits. 
GET /players/ranking/loser: retorna el jugador/a  amb mitjor percentatge d’èxit.  
GET /players/ranking/winner: retorna el  jugador amb pitjor percentatge d’èxit. */
}
