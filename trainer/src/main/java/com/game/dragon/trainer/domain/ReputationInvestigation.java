package com.game.dragon.trainer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReputationInvestigation {
	
	private int people;
	private int state;
	private int underworld;
}
