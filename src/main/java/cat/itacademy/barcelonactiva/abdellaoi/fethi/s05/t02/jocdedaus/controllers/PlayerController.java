package cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.domain.Player;
import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.mappers.PlayerMapper;
import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.services.PlayerService;
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
	
	@PostMapping
	public ResponseEntity<PlayerDTO> addPlayer(PlayerDTO playerDTO) {
		String username = playerDTO.getUsername();
		List<String> usernames = playerService.getUsernames();
		if(usernames.contains(username)) {
			if (username != "ANÒNIM") {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}			
		} else if (username==null || username == "") {
			playerDTO.setUsername("ANÒNIM");
		}
		
		playerService.addPlayer(playerDTO);
		return new ResponseEntity<>(playerDTO,HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<PlayerDTO> updatePlayer(String nom, PlayerDTO playerDTO) {
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
		//
	}
	
	@PostMapping("/{id}/games")
	void addTirada(Long id) {
		
	}
	
	@DeleteMapping("/{id}/games")
	void deleteAllTirades(@PathVariable Long id){
		//playerService.deleteAllTirades(Long id);
	}
	
	
	@GetMapping("")
	List<PlayerDTO> getAllPlayers() {
		return playerService.getAllPlayers();
		
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
