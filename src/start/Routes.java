package start;

import controllers.TestController;
import routing.ControllerDispatcher;
import routing.Route;
import routing.Router;
import server.Request;

/**
 * Created by Oscar on 17/01/2015.
 */
public class Routes {

    public void register() {
        Router router = Router.getInstance();

        router.addRoutes(new Route[] {
                new Route(Request.Method.GET, "/", new ControllerDispatcher(TestController.class, "test")),
                new Route(Request.Method.GET, "/test", new ControllerDispatcher(TestController.class, "test"))
        });
    }

}
