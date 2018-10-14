package com.game.dragon.trainer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.dragon.trainer.domain.GameStart;
import com.game.dragon.trainer.domain.Message;
import com.game.dragon.trainer.domain.MessageSolvingResult;
import com.game.dragon.trainer.domain.ShopList;
import com.game.dragon.trainer.domain.ShopPurchase;

@Service
public class RunGame {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GameActionsService gameService;

	private final int maxLives = 7;
	private final String[] probabilityArray = { "Piece of cake", "Sure thing", "Quite likely", "Hmmm....",
			"Walk in the park", "Risky", "Gamble", "Suicide mission", "Impossible" };

	private String gameId;
	private int currentScore;
	private int currentLives;

	public int run() {
		Boolean gameOver = false;
		ArrayList<Message> messageList = null;
		ArrayList<ShopList> shopArrayList = null;

		startGame();

		do {
			messageList = getMessageList();
			if (shopArrayList == null || shopArrayList.isEmpty()) {
				shopArrayList = getShopItemList();
			}
			Message message = getEasiestMessage(messageList);
			MessageSolvingResult messageSolvingResult = processMessage(message);
			currentScore = messageSolvingResult.getScore();
			currentLives = messageSolvingResult.getLives();
			if (currentLives == 0) {
				gameOver = true;
				break;
			}
			if (currentLives < maxLives && !shopArrayList.isEmpty()
					&& messageSolvingResult.getGold() > shopArrayList.get(0).getCost()) {
				purchaseItem(shopArrayList);
			}
		} while (!gameOver);

		return currentScore;
	}

	private ArrayList<Message> getMessageList() {
		return new ArrayList<Message>(Arrays.asList(gameService.getMessages(gameId)));
	}

	private ArrayList<ShopList> getShopItemList() {
		return new ArrayList<ShopList>(Arrays.asList(gameService.getShopGoods(gameId)));
	}

	private void startGame() {
		GameStart gameStart = gameService.startGame();
		logger.info("Game start: " + gameStart.toString());
		gameId = gameStart.getGameId();
	}

	private MessageSolvingResult processMessage(Message message) {
		logger.info("Solving Message: " + message.toString());
		MessageSolvingResult messageSolvingResult = gameService.solveMessage(gameId, message.getAdId());
		logger.info("Solving Message: " + messageSolvingResult.toString());
		return messageSolvingResult;
	}

	private Message getEasiestMessage(ArrayList<Message> messageArray) {
		Message message = messageArray.get(0);
		for (String probability : probabilityArray) {
			message = FindMessage(messageArray, probability);
			if (message != null) {
				break;
			}
		}
		return message;
	}

	private Message FindMessage(ArrayList<Message> messageArray, String probability) {
		Message message = null;
		try {
			message = messageArray.stream().filter(m -> m.getProbability().equals(probability)).findFirst().get();
		} catch (NoSuchElementException e) {
		}
		return message;
	}

	private void purchaseItem(ArrayList<ShopList> shopArrayList) {
		logger.info("Buying item: " + shopArrayList.get(0).toString());
		ShopPurchase shopPurchase = gameService.purchaseGoods(gameId, shopArrayList.get(0).getId());
		logger.info("Buying item result: " + shopPurchase.toString());
		/* Remove item in case it doesn't increase lives */
		if (shopPurchase.getLives() == currentLives) {
			shopArrayList.remove(0);
		}
	}
}