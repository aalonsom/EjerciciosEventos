package es.upm.dit.adsw.CS_TCP.TCPServerConcPool;

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
    private int nHeadersPool = 5;
    private HandlerPool handlerPool;
    private Sender sender;

    public ConnectionHandler(Socket connection, int id) {
        this.connection = connection;
        this.id         = id;
        handlerPool     = new HandlerPool();
        sender          = new Sender(id, connection);
    }

    public void run () {

        Handler handler;

        // Create handlers in the pool
        for (int i = 0; i < nHeadersPool; i++) {
            handler =  new Handler(id, handlerPool, sender);
            handler.start();
        }

        int sequence = 0;

        try {
            System.out.println("ConnHandler " + id + ": socket waiting messages.");
            inFromClient = new BufferedReader
                    (new InputStreamReader(connection.getInputStream()));

            while (true) {
                message = inFromClient.readLine();
                if (message == null) break;
                handlerPool.put(new HandlerInfo(sequence, message));
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
