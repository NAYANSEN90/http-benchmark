package com.example.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VertxApplication implements CommandLineRunner {

	@Autowired
	private Vertx vertx;

    @Autowired
    private HttpVerticle httpServer;

	@Bean
	Vertx vertx() {
		VertxOptions options = new VertxOptions();
		return Vertx.vertx(options);
	}

	@Override
	public void run(String... arguments) throws Exception {
	    vertx.deployVerticle(httpServer);
	}

	public static void main(String[] args) {
		SpringApplication.run(VertxApplication.class, args);
	}
}
