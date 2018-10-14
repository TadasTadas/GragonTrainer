package com.game.dragon.trainer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
	
	private String adId;
	private String message;
	private String reward;
	private int expiresIn;
	private String probability;
}
