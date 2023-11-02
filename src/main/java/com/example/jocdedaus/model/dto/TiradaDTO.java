package com.example.jocdedaus.model.dto;

import com.example.jocdedaus.model.domain.Tirada;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class TiradaDTO {
	
	private Long Id;
	private Integer de1;
	private Integer de2;
	private Boolean guanyada;
	
	public static TiradaDTO toDTO(Tirada tirada) {
		
		return TiradaDTO.builder()
				.Id(tirada.getId())
				.de1(tirada.getDe1())
				.de2(tirada.getDe2())
				.guanyada(tirada.guanyada())
				.build();
	}

}
