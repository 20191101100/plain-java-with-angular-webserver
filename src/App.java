import blockchain.BCServer;
import renderer.WebAppServer;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebAppServer.getInstance();
        BCServer.getInstance();
        System.out.println("Server On");
        while(true) {
            Thread.sleep(1000);
        }
    }
}
