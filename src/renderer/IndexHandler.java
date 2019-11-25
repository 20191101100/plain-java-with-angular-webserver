package renderer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.Map;

/**
 * Single Page Application을 호출하기 위한 Handler.
 */
public class IndexHandler implements HttpHandler {
    private static final String HandlerPath = "/";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Handler가 지정한 경로와 일치하는가? (path 지정에 정규표현식이 안되므로 여기서 처리해야 한다)
//        String rawPath = exchange.getRequestURI().getRawPath();
//        if (!HandlerPath.equalsIgnoreCase(rawPath)) {
//            exchange.getResponseBody().write(null);
//        }

        switch (exchange.getRequestMethod()) {
            case "POST":
                break;
            case "GET":
            default:
                requestGet(exchange);
        }
//        if (exchange.getRequestURI().equals())
//        Map<String, String> query = ParamUtil.parseQueryString(exchange.getRequestURI().getRawQuery());
//        String resourcePath = String.format("assets%s", exchange.getRequestURI().getPath());
    }

    private void requestGet(HttpExchange exchange) throws IOException {
        String resourcePath = "resources/index.html";
        if (!HandlerPath.equalsIgnoreCase(exchange.getRequestURI().getRawPath())) {
            resourcePath = "resources" + exchange.getRequestURI().getRawPath();
        }

        OutputStream outStream = exchange.getResponseBody();
        InputStream inStream = new BufferedInputStream(new FileInputStream(IndexHandler.class.getResource(resourcePath).getFile()));
        exchange.sendResponseHeaders(200, 0);

        int singleByte = 0;
        while ((singleByte = inStream.read()) != -1) {
            outStream.write(singleByte);
        }
        outStream.close();
    }
}
