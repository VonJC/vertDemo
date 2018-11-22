package com.vert.fjc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * @Author:fjc
 * @Description:
 * @Date: 2018/11/22
 **/
public class Application extends AbstractVerticle {

    @Override
    public void start(Future<Void> f) throws Exception {
        vertx.createHttpServer()
                .requestHandler(req->{
                    req.response().end("Hello Vert.x");
                })
                .listen(8080,result->{
                    if (result.succeeded()){
                        f.complete();
                    }else{
                        f.fail(result.cause());
                    }
                });
    }

}
