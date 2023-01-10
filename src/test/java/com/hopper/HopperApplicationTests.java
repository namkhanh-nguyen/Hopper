package com.hopper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootTest
class HopperApplicationTests {

	@Autowired
	private ContentDatabase contentDatabase;

	@Test
	void contextLoads() {
	}

}
