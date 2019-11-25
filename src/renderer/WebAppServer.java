package renderer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebAppServer {
    private static WebAppServer instance;
    private static int port = 9000;

    private HttpServer http;

    private WebAppServer() throws IOException {
        http = HttpServer.create(new InetSocketAddress(port), 0);
        http.createContext("/", new IndexHandler());
        http.setExecutor(null);
        http.start();
    }

    public static WebAppServer getInstance() throws IOException {
        if (instance == null) {
            instance = new WebAppServer();
        }
        return instance;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        WebAppServer.port = port;
    }
}
