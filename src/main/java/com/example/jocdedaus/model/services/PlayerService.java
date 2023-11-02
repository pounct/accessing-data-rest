package com.example.jocdedaus.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.jocdedaus.model.domain.Player;
import com.example.jocdedaus.model.domain.Tirada;
import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.dto.TiradaDTO;
import com.example.jocdedaus.model.repositories.PlayerRepository;
import com.example.jocdedaus.model.repositories.TiradaRepository;

//import reactor.core.publisher.Flux;

import lombok.AllArgsConstructor;

@AllArgsConstructor
// @Service
public class PlayerService implements IPlayerService{
	
	private PlayerRepository playerRepository;
	private TiradaRepository tiradaRepository;

	@Override
	public void addPlayer(Player player) {
		playerRepository.save(player);
		
	}

	@Override
	public void updatePlayer(Player player) {
		playerRepository.save(player);
		
	}

	@Override
	public void addTirada(Long id,Tirada tirada) {
		tiradaRepository.save(tirada);
		
	}

	@Override
	public void deleteTirades(Long id) {
		tiradaRepository.deleteAllByPlayerId(id);
		
	}

	@Override
	public List<PlayerDTO> getAllPlayers() {
		List<PlayerDTO> players = playerRepository.findAll()
				.stream().map(PlayerDTO::toDTO).toList();
		return players;
	}

	@Override
	public List<TiradaDTO> getAllTirades(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getPercentatgeMitja() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getPercentatgeMitjaMitjor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getPercentatgeMitjaPitjor() {
		// TODO Auto-generated method stub
		return null;
	}

}
