package server;

import fi.iki.elonen.NanoHTTPD;
import routing.Router;

import java.io.IOException;
import java.util.HashMap;

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
            NanoHTTPD.Method method = session.getMethod();

            HashMap files = new HashMap();
            if (method.equals(NanoHTTPD.Method.POST) || method.equals(NanoHTTPD.Method.PUT)) {
                try {
                    session.parseBody(files);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ResponseException e) {
                    e.printStackTrace();
                }
            }

            Request request = this.transformRequest(session);

            request.dump();

            Router router = Router.getInstance();
            server.Response response = router.route(request);

            return this.transformResponse(response);
        }

        protected Request transformRequest(IHTTPSession session) {
            Request request = new Request();
            request.setMethod(Request.Method.fromString(session.getMethod().toString()));
            request.setPath(session.getUri());
            request.setHeaders(session.getHeaders());
            request.setParams(session.getParms());

            return request;
        }

        protected Response transformResponse(server.Response response) {
            Response.Status nanoStatus = null;

            for(Response.Status status : Response.Status.values()) {
                if(status.getRequestStatus() == response.getCode()) {
                    nanoStatus = status;
                }
            }

            Response nanoResponse = new Response(nanoStatus, "text/plain", response.getContent());

            return nanoResponse;
        }
    }

}
