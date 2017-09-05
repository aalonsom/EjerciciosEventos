package es.upm.dit.adsw.CS_TCP_Serial.TCPServer;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import es.upm.dit.adsw.CS_TCP_Serial.Auxiliar.Person;


/**
 * This class is intented to wait for messages from a connection and passing the information
 * to a handler.<
 * The server creates an object ConnectionDispatcher when a socket is accepted and, then, a
 * connection is created
 * @author Alejandro Alonso
 * @version v1.0 20170427
 */
public class ConnectionDispatcher extends Thread {

    //private String capitalizedSentence;
    private Socket connection;
    private int id;

    public ConnectionDispatcher(Socket connection, int id) {
        this.connection = connection;
        this.id         = id;
    }

    public void run () {

        Person clientSentence;
        ObjectInputStream inFromClient;
        ObjectOutputStream outToClient;
        int i = 0;

        try {
            System.out.println("ConnHandler " + id + ": socket waiting messages.");
            inFromClient = new  ObjectInputStream(connection.getInputStream());
            outToClient = new ObjectOutputStream(connection.getOutputStream());
            while (true) {
                //msg = inFromClient.read();
                clientSentence = (Person) inFromClient.readObject();
                //capitalizedSentence = clientSentence.toUpperCase() + '\n';
                if (clientSentence == null) break;
                System.out.println("Socket " + id + " got: " + clientSentence.toString());
                outToClient.writeObject(clientSentence);

                // Test for not sending input Person
                //sleep(1000);
                //outToClient.writeObject(new Person("A ver", i++));
                //outToClient.flush();
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception. Socket " + id + " Connection closed");
        }
        catch (java.io.EOFException e) {

        }
        catch (Exception e) {
            e.printStackTrace();
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
