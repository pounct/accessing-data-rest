package com.example.jocdedaus.model.dto;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;


@Data @Builder
public class PlayerDTO {

	private Long id;
	private String username;
	private LocalDate registrationDate;
	private Float percentatgedExit;
}
