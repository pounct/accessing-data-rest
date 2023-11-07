package com.example.jocdedaus.model.services;

import java.util.List;

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

@AllArgsConstructor
// @Service
public class PlayerService implements IPlayerService{
	
	private PlayerRepository playerRepository;
	private GameRepository gameRepository;

	@Override
	public void addPlayer(Player player) {
		playerRepository.save(player);
		
	}

	@Override
	public void updatePlayer(Player player) {
		playerRepository.save(player);
		
	}

	@Override
	public void addTirada(Long id,Game tirada) {
		gameRepository.save(tirada);
		
	}

	@Override
	public void deleteTirades(Long id) {
		gameRepository.deleteAllByPlayerId(id);
		
	}

	@Override
	public List<PlayerDTO> getAllPlayers() {
		return playerRepository.findAll()
				.stream().map(PlayerMapper::toDTO).toList();
	}

	@Override
	public List<GameDTO> getAllTirades(Long playerId) {
		
		return gameRepository.findAllByPlayerId(playerId)
				.stream().map(GameMapper::toDTO).toList();
	}

	@Override
	public Double getPercentatgeMitja(Long id) {
		
		return null;
	}

	@Override
	public Double getPercentatgeMitjaMitjor() {
		List<Player> players = playerRepository.findAll();
		List<Player> mitjors;
		//List<Float> percentatges = players.forEach(p->percentatgedExit(getAllTirades(p.getId())));
		
		return null;
	}

	@Override
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

}
