package es.upm.dit.adsw.CS_TCP_Serial.TCPClient;

import es.upm.dit.adsw.CS_TCP_Serial.Auxiliar.Person;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Alejandro Alonso
 * @version v1.0 20170904
 */
public class Receiver extends Thread{

    private Socket clientSocket;
    private boolean finished = false;
    private boolean error    = false;
    private int nValue       = 0;


    public Receiver (Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void finish (boolean finished, boolean error, int nValue) {
        this.finished = finished;
        this.nValue   = nValue;
        this.error    = error;
    }

    public void run() {

        Person personMessage;
        ObjectInputStream inFromServer = null;

        int nReceiver    = 0;
        try {
            inFromServer = new ObjectInputStream(clientSocket.getInputStream());
        } catch (Exception e) { // IOException
            System.out.println("Unexpected exception " + e);
        }

        while(!error && !(finished && nValue  <= nReceiver)) {
            try {

                personMessage = (Person) inFromServer.readObject();

                if (personMessage == null) break;
                System.out.println("             Client got: " + personMessage.toString());
                nReceiver ++;
            } catch (Exception e) {
                System.out.println("Unexpected exception " + e);
                break;
            }
        }
        try {
            System.out.println("Socket closed.");
            clientSocket.close();
        } catch (Exception e) { // IOException
            System.out.println("Unexpected exception " + e);
        }
    }
}
