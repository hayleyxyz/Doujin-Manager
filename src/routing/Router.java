package routing;

import server.Request;
import server.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 17/01/2015.
 */
public class Router {

    private static Router instance;

    protected List<Route> routes;

    protected Router() {
        this.routes = new ArrayList<Route>();
    }

    public static Router getInstance() {
        if(instance == null) {
            instance = new Router();
        }

        return instance;
    }

    public void addRoute(Route route) {
        this.routes.add(route);
    }

    public void addRoutes(Route[] routes) {
        this.routes.addAll(Arrays.asList(routes));
    }

    public Response route(Request request) {
        for (Route route : this.routes) {
            if (route.match(request)) {
                return route.dispatch(request);
            }
        }

        return Response.make(404, "route not found");
    }
}
