package com.example.jocdedaus.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jocdedaus.model.domain.Player;
import com.example.jocdedaus.model.dto.GameDTO;
import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.services.PlayerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerController {

	private PlayerService playerService;

	@PostMapping("/players")
	void addPlayer(Player player) {
		//playerService.addPlayer(player);
	}

	@PutMapping("/players") // : modifica el nom del jugador/a.
	void updatePlayer(String nom, Player player) {
		//playerService.updatePlayer(nom, player);
	}
	
	@PostMapping("/players/{id}/games")
	void addTirada(Long id) {
		
	}
	
	@DeleteMapping("/players/{id}/games")
	void deleteAllTirades(@RequestParam Long id){
		//playerService.deleteAllTirades(Long id);
	}
	
	
	@GetMapping("/players")
	List<PlayerDTO> getAllPlayers() {
		return playerService.getAllPlayers();
		
	}
	
	@GetMapping("/players/{id}/games")
	List<GameDTO> getAllTirades(Long playerId){
		return playerService.getAllGames(playerId);
		
	}
	
	@GetMapping("/players/ranking")
	Double getPercentatgeMitja() {
		return null ; //playerService.getPercentatgeMitja();
		
	}
	
	@GetMapping("/players/ranking/loser")
	Double getPercentatgeMitjaMitjor() {
		return playerService.getPercentatgeMitjaMitjor();
		
	}
	
	@GetMapping("/players/ranking/winner")
	Double getPercentatgeMitjaPitjor() {
		return playerService.getPercentatgeMitjaPitjor();
		
	}
	
	

}
