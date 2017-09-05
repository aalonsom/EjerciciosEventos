package es.upm.dit.adsw.CS_TCP_Serial.TCPServer;

/**
 * Created by aalonso on 04/9/17.
 */

import java.net.ServerSocket;
import java.net.Socket;

/**
 * The main in the server. It accepts the socket and creates
 * a dispatcher for managing the messages from the client
 * @author Alejandro Alonso
 * @version v1.0 20170427
 */
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

                ConnectionDispatcher handler = new ConnectionDispatcher(connectionSocket, id);
                System.out.println("Get a socket connection");
                handler.start();
                id++;
            } catch (Exception e) {

            }
        }
        //welcomeSocket.close();
    }

}