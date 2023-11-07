package cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.domain.Player;
import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.services.PlayerService;
import lombok.AllArgsConstructor;

//import java.sql.Date;
//import java.time.Instant;


public class PlayerMapper {
	
	@Autowired
	PlayerService playerService;

	public static PlayerDTO toDTO(Player player) {

		return PlayerDTO.builder()
				.id(player.getId())
				.username(player.getUsername())
				.registrationDate(player.getRegistrationDate())
				//.successesAveragePercentage(playerService.successesAveragePercentage(player))
				.build();
	}
	
	public static Player toPlayer(PlayerDTO dto) {

		return Player.builder()
				.id(dto.getId())
				.username(dto.getUsername())
				.registrationDate(dto.getRegistrationDate())
				.build();
	}

}
