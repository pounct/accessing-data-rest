package cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class GameDTO {
	
	private Long id;
	private Byte dice1;
	private Byte dice2;	
	private Boolean won;
}
