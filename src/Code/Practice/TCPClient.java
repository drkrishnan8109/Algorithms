package Code.Practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by Dhanya on 10/26/17.
 */
public class TCPClient {

    public static void main(String args[]) {
        Socket myClientSocket;
        DataOutputStream os;
        try {
            myClientSocket = new Socket("localhost", 6789);
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            os = new DataOutputStream(myClientSocket.getOutputStream());
            os.writeBytes(inFromUser.readLine());

            BufferedReader inFromServer = new BufferedReader(
                    new InputStreamReader(myClientSocket.getInputStream()));

            String inputLine;
            while((inputLine = inFromServer.readLine()) != null) {
            System.out.println(inputLine);
            }

           /* myClientSocket.close();
            inFromUser.close();
            os.close();*/
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
