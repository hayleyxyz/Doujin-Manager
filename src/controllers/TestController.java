package controllers;

import server.Response;

/**
 * Created by Oscar on 18/01/2015.
 */
public class TestController extends Controller {

    public Response test() {
        return Response.make(200, "Hello from test action!");
    }

}
