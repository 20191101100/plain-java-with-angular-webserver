package blockchain;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class DefaultHandler extends CorsHttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        super.handle(exchange);
        OutputStream outStream = exchange.getResponseBody();
        outStream.write("Hello World".getBytes());
        outStream.close();
    }
}
