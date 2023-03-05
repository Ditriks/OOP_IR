
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class CalculatorClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        String operation = args[0];

        Socket socket = new Socket("localhost", CalculatorServer.PORT_NO);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        pw.println(operation);
        pw.flush();

        if (!"quit".equals(operation.trim())) {
            String line = reader.readLine();
            reader.close();
            System.out.println("Line 36 in Client");
            System.out.println("result: " + line);
            System.out.println("Line 38 in Client");
        }
        socket.close();


    }

}
    

