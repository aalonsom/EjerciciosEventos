package es.upm.dit.adsw.CS_TCP.TCPServer;

/**
 * Created by aalonso on 30/3/17.
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionHandler extends Thread {

    private int msg;
    private String clientSentence;
    private String capitalizedSentence;
    private Socket connection;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private int id;

    public ConnectionHandler(Socket connection, int id) {
        this.connection = connection;
        this.id         = id;
    }

    public void run () {
        try {
            System.out.println("ConnHandler " + id + ": socket waiting messages.");
            inFromClient = new BufferedReader
                    (new InputStreamReader(connection.getInputStream()));
            outToClient = new DataOutputStream(connection.getOutputStream());
            while (true) {
                //msg = inFromClient.read();
                clientSentence = inFromClient.readLine();
                //capitalizedSentence = clientSentence.toUpperCase() + '\n';
                if (clientSentence == null) break;
                System.out.println("Socket " + id + " got: " + clientSentence);
                outToClient.writeBytes(clientSentence + "\n");
                outToClient.flush();
            }
        }
        catch (java.lang.NullPointerException e) {
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
