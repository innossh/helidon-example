package innossh.helidon.example.metrics;

import io.helidon.metrics.MetricsSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

public class Main {

    public static void main(final String[] args) {
        WebServer.create(
                ServerConfiguration.builder().port(8080).build(),
                Routing.builder()
                        .register(MetricsSupport.create())
                        .get("/greet", (req, res)
                                -> res.send("Hello World!")))
                .start();
    }

}
