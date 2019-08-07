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
            while(true) {
                socket = serverSocket.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(bufferedReader.readLine() + socket.toString());
            }
        } catch (Throwable th) { }
    }
}
