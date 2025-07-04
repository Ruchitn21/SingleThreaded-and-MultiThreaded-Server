import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() {
        int port = 8010;
        try{
            ServerSocket socket = new ServerSocket(port);
            socket.setSoTimeout(10000); // Set a timeout of 10 seconds
            while(true) {
                System.out.println("Server is listening at port: "+port);
                Socket acceptedConnection = socket.accept();
                System.out.println("Connection established with: " + acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Welcome to the server!");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();
            }
        } catch (IOException e) {
            System.out.println("Error initializing server on port " + port + ": " + e.getMessage());
        }


    }
    public static void main(String[] args) {
        Server server = new Server();
        try{
            server.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}