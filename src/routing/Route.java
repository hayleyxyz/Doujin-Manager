package routing;

import server.Request;
import server.Response;

import java.lang.reflect.Method;

/**
 * Created by Oscar on 17/01/2015.
 */
public class Route {

    protected Request.Method method;
    protected String path;

    protected RouteDispatcher dispatcher;

    public Route(Request.Method method, String path, RouteDispatcher dispatcher) {
        this.method = method;
        this.path = path;
        this.dispatcher = dispatcher;
    }

    public boolean match(Request request) {
        if(request.getMethod() != this.method) {
            return false;
        }

        if(!request.getPath().equals(this.path)) {
            return false;
        }

        return true;
    }

    public Response dispatch(Request request) {
        return this.dispatcher.dispatch(request, this);
    }

    @Override
    public String toString() {
        return this.method + " " + this.path;
    }
}
