package routing;

import server.Request;
import server.Response;

/**
 * Created by Oscar on 18/01/2015.
 */
public interface RouteDispatcher {

    public Response dispatch(Request request, Route route);

}
