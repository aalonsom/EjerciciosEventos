package es.upm.dit.adsw.CS_TCP.TCPServerConcurrency;

import java.util.Random;

/**
 * Created by aalonso on 31/3/17.
 */

import java.io.DataOutputStream;
import java.net.Socket;

public class Handler extends Thread{

    // The id of the server
    private int id;
    // The order of the message received from the client
    private int sequence;
    private String message;
    private Socket connection;

    public Handler(int id, int sequence, String message, Socket connection) {
        this.id          = id;
        this.sequence    = sequence;
        this.message    = message;
        this.connection = connection;
    }

    public void run() {
        Random random = new Random();
        int bound = 10;
        DataOutputStream outToClient;


        // Simulate processing time for handling the message
        try {
            System.out.println(">> Socket: " + id + " Sequence: " + sequence);
            Thread.sleep(random.nextInt(bound) * 1000);

            outToClient = new DataOutputStream(connection.getOutputStream());
            outToClient.writeBytes(message + "\n");
            outToClient.flush();

            //counter.Add()
            System.out.println("<< Socket: " + id + " Sequence: " + sequence + " Sent: " + message);
        } catch (InterruptedException e) {

        } catch (java.io.IOException e) {
            System.out.println("Exception. Socket " + id + " Connection closed");
        } catch (Exception e) {
            System.out.println("Unexpected exception");
        }
        //try {
        //    connection.close();
        //} catch (Exception e) {
        //    return;
        //}

    }

}
