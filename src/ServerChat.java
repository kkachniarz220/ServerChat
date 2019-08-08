import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat{

    public static void main(int port) throws IOException{
        Socket socket;
        ServerSocket serverSocket;
        BufferedReader bufferedReader;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("\nServer is running on " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort() + "\n");
                System.out.println("\n\nWaiting for a client...\n");
                socket = serverSocket.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Client " + bufferedReader.readLine().toUpperCase() + " connected");
            while(true) {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(bufferedReader.readLine());
            }
        } catch (Throwable th) {
            System.out.println(th);
        }
    }
}
