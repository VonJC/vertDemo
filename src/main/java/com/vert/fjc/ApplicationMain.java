package com.vert.fjc;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * @Author:fjc
 * @Description:
 * @Date: 2018/11/22
 **/
public class ApplicationMain extends AbstractVerticle {

    public static Vertx vertx;
    public static HttpServer httpServer;

    public static void main(String[] args) {

        vertx = Vertx.vertx();
        // 部署发布rest服务
        vertx.deployVerticle(new ApplicationMain());

//        Vertx.vertx().createHttpServer().
//
//    requestHandler(req->
//
//    {
//        req.response().end("Hello Vert.x");
//    }).listen(8088);

}

    @Override
    public void start() throws Exception {
        System.out.println("start");
        httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/*").handler(StaticHandler.create());

//        router.route().handler(routingContext -> {
//
//            // 所有的请求都会调用这个处理器处理
//            HttpServerResponse response = routingContext.response();
//            response.putHeader("content-type", "text/plain");
//            String html = "<html><head></head><body><input/></body></html>";
//            // 写入响应并结束处理
////            response.end(html);
//            routingContext.put("foo", "bar");
//            routingContext.next();
//        });
//        router.route().handler(routingContext -> {
//            HttpServerRequest request = routingContext.request();
//            String param = request.getParam("p");
//            System.out.println("param"+param);
//            System.out.println("routingContext"+routingContext.get("foo"));
//            String html = "<html><head></head><body><input/></body></html>";
//            routingContext.response().end(html);
//        });
//
//        router.get("/some/path/B").handler(routingContext -> {
//            routingContext.response().end();
//        });

        httpServer.requestHandler(router::accept).listen(8088);
    }

    public void searchResult(RoutingContext context) {
        System.out.println("searchResult");
        context.response().end("ok");
        System.out.println(context.getBodyAsString());
    }

}
