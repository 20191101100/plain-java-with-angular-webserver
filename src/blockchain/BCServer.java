package blockchain;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class BCServer {
    public static int port = 8000;
    private static BCServer instance;

    private HttpServer server;

    private BCServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new DefaultHandler());
        server.start();
    }

    public static BCServer getInstance() throws IOException {
        if (instance == null) {
            instance = new BCServer();
        }
        return instance;
    }
}
