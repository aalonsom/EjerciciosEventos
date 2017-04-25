package es.upm.dit.adsw.CS_TCP.TCPServerConcPool;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by aalonso on 2/4/17.
 */
public class Sender {

    private Socket connection;
    // The id of the server
    private int id;
    DataOutputStream outToClient;


    public Sender(int id, Socket connection) {
        this.id        = id;
        this.connection = connection;
        try {
            outToClient = new DataOutputStream(connection.getOutputStream());
        } catch (Exception e) {

        }
    }

    public synchronized void send (HandlerInfo handlerInfo) {
        try {
            outToClient.writeBytes(handlerInfo.getMessage() + "\n");
            outToClient.flush();
            System.out.println("<< Socket: " + id + " Sequence: " + handlerInfo.getSequence()
                    + " Sent: " + handlerInfo.getMessage());
        } catch (java.io.IOException e) {
            System.out.println("Exception. Socket " + id + " Connection closed");
        } catch (Exception e) {
            System.out.println("Unexpected exception");
        }
    }

}
