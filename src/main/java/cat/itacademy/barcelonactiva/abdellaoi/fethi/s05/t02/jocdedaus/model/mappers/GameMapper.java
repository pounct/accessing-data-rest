package cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.mappers;

import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.domain.Game;
import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.dto.GameDTO;

public class GameMapper {
	
	public static GameDTO toDTO(Game game) {

		return GameDTO.builder()
				.id(game.getId())
				.dice1(game.getDice1())
				.dice2(game.getDice2())
				.won(game.won())
				.build();
	}

}
