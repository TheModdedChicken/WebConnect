package io.github.themoddedchicken.WebConnect.endpoints;

import io.javalin.Javalin;
import org.json.simple.JSONObject;

public class LoginRouter {
    public LoginRouter(Javalin server) {
        server.get("/provider", ctx -> {
            JSONObject out = new JSONObject();
            out.put("name", "Google Test");

            ctx.json(out);
        });
    }
}
