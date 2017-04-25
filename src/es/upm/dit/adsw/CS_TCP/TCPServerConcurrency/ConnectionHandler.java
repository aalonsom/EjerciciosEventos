package es.upm.dit.adsw.CS_TCP.TCPServerConcurrency;

/**
 * Created by aalonso on 30/3/17.
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionHandler extends Thread {

    private String message;
    private Socket connection;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private int id;

    public ConnectionHandler(Socket connection, int id) {
        this.connection = connection;
        this.id         = id;
    }

    public void run () {

        Handler handler;
        int sequence = 0;

        try {
            System.out.println("ConnHandler " + id + ": socket waiting messages.");
            inFromClient = new BufferedReader
                    (new InputStreamReader(connection.getInputStream()));

            while (true) {
                message = inFromClient.readLine();
                if (message == null) break;

                handler = new Handler(id, sequence, message, connection);
                handler.start();
                sequence ++;
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception. Socket " + id + " Connection closed");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            //id ++;
            System.out.println("Server " + id + ": connection closed");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
