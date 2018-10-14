package com.game.dragon.trainer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopPurchase {
	
	private String shoppingSuccess;
	private int gold;
	private int lives;
	private int level;
	private int turn;
}
