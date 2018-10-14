package com.game.dragon.trainer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameStart {
	
	private String gameId;
	private int lives;
	private int gold;
	private int level;
	private int score;
	private int highScore;
	private int turn;
	
}
