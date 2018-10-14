package com.game.dragon.trainer.service;

import com.game.dragon.trainer.domain.GameStart;
import com.game.dragon.trainer.domain.Message;
import com.game.dragon.trainer.domain.MessageSolvingResult;
import com.game.dragon.trainer.domain.ReputationInvestigation;
import com.game.dragon.trainer.domain.ShopList;
import com.game.dragon.trainer.domain.ShopPurchase;

public interface GameActionsService {
	
	public GameStart startGame();
	public ReputationInvestigation investigateReputation(String gameId);
	
	public Message[] getMessages(String gameId);
	
	public MessageSolvingResult solveMessage(String gameId, String messageId);
	
	public ShopList[] getShopGoods(String gameId);
	
	public ShopPurchase purchaseGoods(String gameId, String itemId);

}
