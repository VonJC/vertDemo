package com.vert.fjc;

import io.vertx.core.Vertx;

/**
 * @Author:fjc
 * @Description:
 * @Date: 2018/11/22
 **/
public class ApplicationMain {

    public static void main(String[] args) {
        Vertx.vertx().createHttpServer()
                .requestHandler(req->{
                    req.response().end("Hello Vert.x");
                }).listen(8080);
    }

}
