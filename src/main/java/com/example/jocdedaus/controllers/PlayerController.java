package com.example.jocdedaus.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jocdedaus.model.domain.Game;
import com.example.jocdedaus.model.domain.Player;
import com.example.jocdedaus.model.dto.GameDTO;
import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.mappers.GameMapper;
import com.example.jocdedaus.model.services.PlayerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {
	
	PlayerService playerService;
	
//	@PostMapping("")
//	public ResponseEntity<PlayerDTO> create(@RequestBody PlayerDTO pdto){
//		playerService.add(pdto);
//		return new ResponseEntity<>(pdto,HttpStatus.CREATED);		
//	}
	
	@PostMapping("")
	public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO) {
		System.out.println(playerDTO.toString());
		String username = playerDTO.getUsername();
		System.out.println(username);
		List<String> usernames = playerService.getUsernames();
		System.out.println(usernames);
		if(usernames.contains(username) &&  (!username.equalsIgnoreCase("ANÒNIM") )) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);						
		}
		if (username==null || (!username.equals(""))) {
			playerDTO.setUsername("ANÒNIM");
		}
		playerDTO.setRegistrationDate(LocalDate.now());
		playerService.addPlayer(playerDTO);
		return new ResponseEntity<>(playerDTO,HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<PlayerDTO> updatePlayer(@RequestBody String nom, @RequestBody PlayerDTO playerDTO) {
		PlayerDTO pdto = playerService.getPlayerDTO(playerDTO.getId());
		if (pdto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<String> usernames = playerService.getUsernames();
		if(usernames.contains(nom)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		playerService.updatePlayer(nom, playerDTO);
		return new ResponseEntity<>(pdto, HttpStatus.OK);
	}
	
	@PostMapping("/{id}/games")
	public ResponseEntity<GameDTO> addGame(Long id,GameDTO gameDTO) {
		PlayerDTO pdto = playerService.getPlayerDTO(id);
		if (pdto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		playerService.playGame(id, gameDTO);
		return new ResponseEntity<>(gameDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/games")
	void deleteAllTirades(@PathVariable Long id){
		//playerService.deleteAllTirades(Long id);
	}
	
	
	@GetMapping("")
	ResponseEntity<List<PlayerDTO>> getAllPlayers() {
		return new ResponseEntity<>( playerService.getAllPlayers(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}/games")
	List<GameDTO> getAllTirades(@PathVariable Long playerId){
		return playerService.getAllGames(playerId);
		
	}
	
	@GetMapping("/ranking")
	Double getPercentatgeMitja() {
		return null ; //playerService.getPercentatgeMitja();
		
	}
	
	@GetMapping("/ranking/loser")
	Double getPercentatgeMitjaMitjor() {
		return playerService.getPercentatgeMitjaMitjor();
		
	}
	
	@GetMapping("/ranking/winner")
	Double getPercentatgeMitjaPitjor() {
		return playerService.getPercentatgeMitjaPitjor();
		
	}
	

}