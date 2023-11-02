package com.example.jocdedaus.model.dto;

import java.util.Date;

import com.example.jocdedaus.model.domain.Player;
import lombok.Builder;
import lombok.Data;
import lombok.Builder.Default;

@Data @Builder
public class PlayerDTO {
	
	private Long id;
	@Default
	private String nom="ANÒNIM";
	private Date dataRegistre;
	private Float percentatgedExit;
	

public static PlayerDTO toDTO(Player player) {
		
		return PlayerDTO.builder()
				.id(player.getId())
				.nom(player.getNom())
				.dataRegistre(player.getDataRegistre())
				.percentatgedExit(player.percentatgedExit())
				.build();
	}
}
