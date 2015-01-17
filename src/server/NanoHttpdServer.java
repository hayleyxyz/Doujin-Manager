package server;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

/**
 * Created by Oscar on 17/01/2015.
 */
public class NanoHttpdServer implements HttpServer {

    protected NanoHttpdHandler handler;

    @Override
    public void start(int port) throws IOException {
        this.handler = new NanoHttpdHandler(port);
        this.handler.start();
    }

    @Override
    public void stop() {
        this.handler.stop();
    }

    public class NanoHttpdHandler extends NanoHTTPD {

        public NanoHttpdHandler(int port) {
            super(port);
        }

        @Override
        public NanoHTTPD.Response serve(IHTTPSession session) {
            Request request = new Request();



            Method method = session.getMethod();
            String uri = session.getUri();
            System.out.println(method + " '" + uri + "' ");


            return new NanoHTTPD.Response("Hello world!");
        }
    }

}
