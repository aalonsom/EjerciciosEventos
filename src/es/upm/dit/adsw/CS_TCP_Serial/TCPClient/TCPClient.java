package es.upm.dit.adsw.CS_TCP_Serial.TCPClient;

import es.upm.dit.adsw.CS_TCP_Serial.Auxiliar.Person;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;


/**
 * @author Alejandro Alonso
 * @version v1.0 20170904
 */
public class TCPClient {

    public static void main(String[] args) { //throws Exception{

        Socket clientSocket;
        ObjectOutputStream outToServer;

        int nTimes      = 3;
        String hostname = "127.0.0.1";
        int port        = 6789;
        Random random = new Random();
        int bound       = 10;

        try {
            clientSocket = new Socket(hostname, port);
            outToServer  = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Receiver receiver = new Receiver(clientSocket);
        receiver.start();

        try {

            for (int i = 0; i < nTimes; i++) {
                System.out.println("Sequence: " + i);

                outToServer.writeObject(new Person("Pepe", i));
                outToServer.flush();

                Thread.sleep(random.nextInt(bound) * 500);
            }
        } catch (Exception e) { // IOException
            receiver.finish(false, true, 0);
            e.printStackTrace();
        }

        System.out.println("Finish the client");
        receiver.finish(true, false, nTimes);

    }
}


