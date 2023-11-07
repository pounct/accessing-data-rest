package com.example.jocdedaus.model.domain;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "player-dto",types = Player.class)
public interface PlayerProjection {
	
	public Long getId();
	public String getNom();
	public Date getDataRegistre();
	public Float getPercentatgedExit();

}
