package Code.Practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPServer {

    //Receives message from client and sends back the uppercase message
    public static void main(String args[]) throws Exception{
        ServerSocket serverSocket = null;
        Socket connectionSocket = null;

        try {
            serverSocket = new ServerSocket(6789);
           try{
               connectionSocket = serverSocket.accept();
           }catch(UnknownHostException e){
               System.out.println("Host Unknown");
           }
            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader((connectionSocket.getInputStream())));
            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            String inputLine;
            while(true){
            while((inputLine = inFromClient.readLine()) != null) {
                String upperLine = inputLine.toUpperCase();
                outToClient.writeBytes(upperLine);
            }
            }
        }catch(Exception e){
        e.printStackTrace();
        }
    }

}
