package com.example.jocdedaus.model.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class GameDTO {
	
	private Long Id;
	private Byte dice1;
	private Byte dice2;	
	private Boolean won;

}
