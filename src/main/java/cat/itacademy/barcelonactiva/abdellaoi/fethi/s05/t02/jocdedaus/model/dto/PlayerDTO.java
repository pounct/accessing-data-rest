package cat.itacademy.barcelonactiva.abdellaoi.fethi.s05.t02.jocdedaus.model.dto;


import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDTO {
	
	private Long id;
	private String username;
	private LocalDate registrationDate;
	private Float successesAveragePercentage;
}
