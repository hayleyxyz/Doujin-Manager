package server;


/**
 * Created by Oscar on 17/01/2015.
 */
public interface HttpServer {

    public void start(int port) throws Exception;

    public void stop();

}
