package com.example.jocdedaus.model.mappers;

//import java.sql.Date;
//import java.time.Instant;

import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.domain.Player;

public class PlayerMapper {

	public static PlayerDTO toDTO(Player player) {

		return PlayerDTO.builder()
				.id(player.getId())
				.username(player.getUsername())
				.registrationDate(player.getRegistrationDate())
				//.percentatgedExit(player.percentatgedExit())
				.build();
	}

//	public static Player fromDTO(PlayerDTO dto) {
//
//		return Player.builder()
//				.id(dto.getId())
//				.username(dto.getUsername())
//				.registrationDate(dto.getRegistrationDate())
//				.build();
//	}
	
	public static Player toPlayer(PlayerDTO dto) {

		return Player.builder()
				//.id(dto.getId())
				.username(dto.getUsername())
				.registrationDate(dto.getRegistrationDate())
				.build();
	}

}
