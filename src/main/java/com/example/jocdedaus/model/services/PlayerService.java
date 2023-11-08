package com.example.jocdedaus.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jocdedaus.model.domain.Game;
import com.example.jocdedaus.model.domain.Player;
import com.example.jocdedaus.model.dto.GameDTO;
import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.mappers.GameMapper;
import com.example.jocdedaus.model.mappers.PlayerMapper;
import com.example.jocdedaus.model.repositories.GameRepository;
import com.example.jocdedaus.model.repositories.PlayerRepository;

//import reactor.core.publisher.Flux;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlayerService {
	
	private PlayerRepository playerRepository;
	private GameRepository gameRepository;

	//	public void add(PlayerDTO pdto) {
	//	Player player = PlayerMapper.toPlayer(pdto);		
	//	playerRepository.save(player);		
	//}
	
	
	
	//@Override
	public void addPlayer(PlayerDTO pdto) {		
		playerRepository.save(PlayerMapper.toPlayer(pdto));		
	}
	
	//@Override
	public void updatePlayer(String nom, PlayerDTO pdto) {
		Player player = PlayerMapper.toPlayer(pdto);
		player.setUsername(nom);
		playerRepository.save(player);
		
	}
	
	//@Override
	public void playGame(Long id,GameDTO gameDTO) {
		Game game = GameMapper.toGame(gameDTO);
		Optional<Player> player = playerRepository.findById(id);
		if (player.isPresent()) {
			game.setPlayer(player.get());
			gameRepository.save(game);
		}		
	}
	
	//@Override
	public void deleteTirades(Long id) {
		gameRepository.deleteAllByPlayerId(id);
		
	}
	
	//@Override
	public List<PlayerDTO> getAllPlayers() {
		return playerRepository.findAll()
				.stream().map(PlayerMapper::toDTO).toList();
	}
	
	//@Override
	public List<GameDTO> getAllTirades(Long playerId) {
		
		return gameRepository.findAllByPlayerId(playerId)
				.stream().map(GameMapper::toDTO).toList();
	}
	
	//@Override
	public Double getPercentatgeMitja(Long id) {
		
		return null;
	}
	
	//@Override
	public Double getPercentatgeMitjaMitjor() {
		List<Player> players = playerRepository.findAll();
		List<Player> mitjors;
		//List<Float> percentatges = players.forEach(p->percentatgedExit(getAllTirades(p.getId())));
		
		return null;
	}
	
	//@Override
	public Double getPercentatgeMitjaPitjor() {
		
		return null;
	}
	
	public Float percentatgedExit(List<Game> games) {
		Integer tiradesGuanyades = 0;
		if (!games.isEmpty()) {
			for (Game t : games) {
				if (Boolean.TRUE.equals(t.won())) {
					tiradesGuanyades += 1;
				}
			}
			return ((float) tiradesGuanyades / games.size() * 100);
		}
		return null;
	}
	
	public List<GameDTO> getAllGames(Long playerId) {
		
		return gameRepository.findAllByPlayerId(playerId)
				.stream().map(GameMapper::toDTO).toList();
	}
	
	public List<String> getUsernames() {
		
		List<String> usernames = playerRepository.findAll()
				.stream().map(p->p.getUsername()).toList();
		return usernames;
	}
	
	public PlayerDTO getPlayerDTO(Long id) {
		
		Optional<Player> p = playerRepository.findById(id);
		if (p.isPresent()) {
			return PlayerMapper.toDTO(p.get());
		}
		return null;
	}

}
