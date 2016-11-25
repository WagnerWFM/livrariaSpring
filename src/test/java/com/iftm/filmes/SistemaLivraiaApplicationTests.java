package com.iftm.filmes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iftm.livraria.SistemaLivraiaApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SistemaLivraiaApplication.class)
@WebAppConfiguration
public class SistemaLivraiaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
