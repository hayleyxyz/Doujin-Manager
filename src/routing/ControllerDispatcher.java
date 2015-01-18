package routing;

import controllers.Controller;
import server.Request;
import server.Response;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Oscar on 18/01/2015.
 */
public class ControllerDispatcher implements RouteDispatcher {

    protected Class controllerClass;
    protected String methodName;

    public ControllerDispatcher(Class controllerClass, String methodName) {
        this.controllerClass = controllerClass;
        this.methodName = methodName;
    }

    @Override
    public Response dispatch(Request request, Route route) {
        Method action;

        try {
            action = this.controllerClass.getMethod(this.methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return Response.make(500);
        }

        Controller controller;

        try {
            Constructor ctor = this.controllerClass.getConstructor();
            controller = (Controller)ctor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.make(500);
        }

        try {
            return (Response)action.invoke(controller);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.make(500);
    }
}
