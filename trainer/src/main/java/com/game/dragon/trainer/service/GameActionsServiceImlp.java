package com.game.dragon.trainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.game.dragon.trainer.domain.GameStart;
import com.game.dragon.trainer.domain.Message;
import com.game.dragon.trainer.domain.MessageSolvingResult;
import com.game.dragon.trainer.domain.ReputationInvestigation;
import com.game.dragon.trainer.domain.ShopList;
import com.game.dragon.trainer.domain.ShopPurchase;


@Service
public class GameActionsServiceImlp implements GameActionsService{
	
	private RestTemplate restTemplate;
	
	@Value("${external.service.url}")
	private String url;
	
	@Autowired
	public GameActionsServiceImlp(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public GameStart startGame() {
		return restTemplate.postForObject(url+"api/v2/game/start", null, GameStart.class);
	}
	
	public ReputationInvestigation investigateReputation(String gameId) {
		return this.restTemplate.postForObject(url+"api/v2/{gameId}/investigate/reputation", null, ReputationInvestigation.class, gameId);
	}
	
	public Message[] getMessages(String gameId) {
		return this.restTemplate.getForObject(url+"api/v2/{gameId}/messages", Message[].class, gameId);
	}
	
	public MessageSolvingResult solveMessage(String gameId, String adId) {
		return this.restTemplate.postForObject(url+"api/v2/{gameId}/solve/{adId}", null, MessageSolvingResult.class, gameId, adId);
	}
	
	public ShopList[] getShopGoods(String gameId) {
		return this.restTemplate.getForObject(url+"api/v2/{gameId}/shop", ShopList[].class, gameId);
	}
	
	public ShopPurchase purchaseGoods(String gameId, String itemId) {
		return this.restTemplate.postForObject(url+"api/v2/{gameId}/shop/buy/{itemId}", null, ShopPurchase.class, gameId, itemId);
	}

}
