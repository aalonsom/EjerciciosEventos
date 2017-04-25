package es.upm.dit.adsw.CS_TCP.TCPServer;

/**
 * Created by aalonso on 30/3/17.
 */

import java.net.*;

public class TCPServer {

    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        Socket connectionSocket;

        int id = 0;

        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            try {
                connectionSocket = welcomeSocket.accept();

                ConnectionHandler handler = new ConnectionHandler(connectionSocket, id);
                System.out.println("Get a socket connection");
                handler.start();
                id++;
            } catch (Exception e) {

            }
        }
        //welcomeSocket.close();
    }

}