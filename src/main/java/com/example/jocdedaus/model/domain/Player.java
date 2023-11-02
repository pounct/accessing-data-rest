package com.example.jocdedaus.model.domain;

import java.util.Date;
import java.util.List;

import com.example.jocdedaus.model.dto.PlayerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Default
	// @Column(unique=true)
	private String nom = "ANÒNIM";
	private Date dataRegistre;

	//private List<Tirada> tirades;

	public Float percentatgedExit() {
//		Integer tiradesGuanyades = 0;
//		if (!tirades.isEmpty()) {
//			for (Tirada t : tirades) {
//				if (Boolean.TRUE.equals(t.guanyada())) {
//					tiradesGuanyades += 1;
//				}
//			}
//			return ((float) tiradesGuanyades / tirades.size() * 100);
//		}
		return null;
	}

	public static Player toPlayer(PlayerDTO dto) {

		return Player.builder()
				.id(dto.getId())
				.nom(dto.getNom())
				.dataRegistre(dto.getDataRegistre())
				.build();
	}

}
