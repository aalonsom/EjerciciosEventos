package es.upm.dit.adsw.CS_TCP.TCPClient;

import java.io.*;
import java.net.*;
import java.util.Random;

/**
 * @author Alejandro Alonso
 * @version v1.0 20170427
 */
public class TCPClient {

    public static void main(String[] args) { //throws Exception{

        Socket clientSocket;
        DataOutputStream outToServer;

        int nTimes      = 10;
        String hostname = "127.0.0.1";
        int port        = 6789;
        Random random = new java.util.Random();
        int bound       = 10;

        try {
            clientSocket = new Socket(hostname, port);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Receiver receiver = new Receiver(clientSocket);
        receiver.start();

        try {

            for (int i = 0; i < nTimes; i++) {
                System.out.println("Sequence: " + i);

                outToServer.writeBytes(i + "\n");
                outToServer.flush();

                Thread.sleep(random.nextInt(bound) * 1000);
            }
        } catch (Exception e) { // IOException
            receiver.finish(false, true, 0);
            e.printStackTrace();
        }

        receiver.finish(true, false, nTimes);

    }
}


