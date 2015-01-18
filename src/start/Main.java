package start;


/**
 * Created by Oscar on 17/01/2015.
 */
public class Main {

    public static void main(String[] args) {

        Routes routes = new Routes();
        routes.register();

        Server server = new Server();
        try {
            server.start();
        } catch (Exception e) {
        }

        System.out.println("Server started, Hit Enter to stop.\n");

        try {
            System.in.read();
        } catch (Throwable ignored) {
        }

        server.stop();
        System.out.println("Server stopped.\n");
    }

}
