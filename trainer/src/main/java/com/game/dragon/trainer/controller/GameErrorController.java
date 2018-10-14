package com.game.dragon.trainer.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameErrorController implements ErrorController{
	
	@RequestMapping("/error")
    public String handleError() {
        return "Technical error occurred. Please try again later";
    }
	
	@Override
    public String getErrorPath() {
        return "/error";
    }
}
