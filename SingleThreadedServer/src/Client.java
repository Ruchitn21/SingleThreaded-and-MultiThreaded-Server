import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void run() {
        int port = 8010;
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket socket = new Socket(address, port);
            PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toSocket.println("Hello from the client!");
            String line = fromSocket.readLine();
            System.out.println("Response from the socket: "+line);
            toSocket.close();
            fromSocket.close();
            socket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
