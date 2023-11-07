package com.example.jocdedaus.model.mappers;

import com.example.jocdedaus.model.domain.Game;
import com.example.jocdedaus.model.dto.GameDTO;

public class GameMapper {

	public static GameDTO toDTO(Game game) {

		return GameDTO.builder()
				.Id(game.getId())
				.dice1(game.getDice1())
				.dice2(game.getDice2())
				.won(game.won())
				.build();
	}

}
