package com.game.dragon.trainer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.game.dragon.trainer.service.RunGame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainerApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RunGame runGame;

	@Test
	public void contextLoads() {
	}
	
	@Test
	//@Repeat(10)
    public void runGameService() throws Exception {
		int gameScore = runGame.run();
		logger.info("Game Score: "+gameScore);
        assertThat(gameScore > 1000);
    }
}
