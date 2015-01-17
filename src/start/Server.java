package start;

import server.HttpServer;
import server.NanoHttpdServer;

/**
 * Created by Oscar on 17/01/2015.
 */
public class Server {

    protected HttpServer server;

    public void start() throws Exception {
        this.server = new NanoHttpdServer();
        this.server.start(8080);
    }

    public void stop() {
        this.server.stop();
    }

}
