package com.example.vertx;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.BlockingHandler;
import io.undertow.util.Headers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UndertowApplication implements CommandLineRunner {

	@Override
	public void run(String... arguments) throws Exception {

		Undertow server = Undertow.builder()
				.addHttpListener(8080, "0.0.0.0")
				.setHandler(
				        Handlers.path()
                                .addExactPath("/ping",
                                        new BlockingHandler(
                                                new HttpHandler() {
                                                    @Override
                                                    public void handleRequest(HttpServerExchange exchange) throws Exception {
                                                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                                                        exchange.getResponseSender().send("pong");
                                                    }
                                                }
                                        )
                                )
                ).build();
		server.start();
	}

	public static void main(String[] args) {
		SpringApplication.run(UndertowApplication.class, args);
	}
}
