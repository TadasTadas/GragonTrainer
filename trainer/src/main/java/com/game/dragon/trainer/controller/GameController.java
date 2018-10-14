package com.game.dragon.trainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.dragon.trainer.service.RunGame;

@RestController
public class GameController {
	
	@Autowired
	RunGame runGame;

    @RequestMapping("/")
    public String index() {
        return "Please use {currentURL}/playGame to run this application";
    }
    
    @RequestMapping("/playGame")
    public String playGame() {
        return "Your score in the game is "+runGame.run();
    }
    
}