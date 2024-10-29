package io.github.themoddedchicken.WebConnect.lib.managers;

import io.github.themoddedchicken.WebConnect.WebConnect;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class WebManager {
    WebConnect plugin;
    Javalin server;

    public WebManager (WebConnect plugin, int port, String path, boolean external_panel) {
        this.plugin = plugin;

        server = Javalin.create(c -> {
            c.router.contextPath = path;
            c.router.ignoreTrailingSlashes = true;
            c.router.treatMultipleSlashesAsSingleSlash = true;

            c.staticFiles.add(staticFiles -> {
                staticFiles.directory =
                        external_panel
                        ? ("plugins/" + this.plugin.getName() + "/web") // Look in plugins folder
                        : "/web";                                       // Look at internal resources
                staticFiles.location =
                        external_panel
                        ? Location.EXTERNAL
                        : Location.CLASSPATH;
            });
        });

        server.start(port);
    }
}
