package com.example.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.sync.SyncVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.springframework.stereotype.Component;

/**
 * Created by stb.
 */
@Component
//public class HttpVerticle extends SyncVerticle {
public class HttpVerticle extends AbstractVerticle {

    private Router router() {
        Router router = Router.router(vertx);
        //router.route("/ping").handler(routingContext -> {
        //    HttpServerResponse response = routingContext.response();
        //    response.putHeader("Content-Type", "text/plain");
        //    response.end("pong");
        //});

        router.route("/ping").blockingHandler(new Handler<RoutingContext>() {
            @Override
            public void handle(RoutingContext routingContext) {
                HttpServerResponse response = routingContext.response();
                response.putHeader("Content-Type", "text/plain");
                response.end("pong");
            }
        });

        return router;
    }

    @Override
    public void start(Future<Void> future) {
        vertx.createHttpServer().requestHandler(router()::accept).listen(8080);
    }
}
