package es.upm.dit.adsw.CS_TCP.TCPClient;

/**
 * Created by aalonso on 30/3/17.
 */

import java.io.*;
import java.net.*;
import java.util.Random;

    public class TCPClient {


        public static void main(String[] args) { //throws Exception{

            Socket clientSocket;
            DataOutputStream outToServer = null;
            BufferedReader inFromServer  = null;

            int     nTimes      = 10;
            String  hostname    = "127.0.0.1";
            int     port        = 6789;
            String  msg;
            Random random       = new java.util.Random();

            try {
                clientSocket = new Socket(hostname, port);
                outToServer  = new DataOutputStream(clientSocket.getOutputStream());
                inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (Exception e) {
                System.out.println(e);
                return;
            }

            Receiver receiver = new Receiver(clientSocket);
            receiver.start();

            try {

                  for (int i = 0; i < nTimes; i++) {
                      System.out.println("Sequence: " + i);

                      outToServer.writeBytes(i + "\n");
                      outToServer.flush();

                      Thread.sleep(1500);
                  }
            } catch (Exception e) { // IOException
                receiver.finish(false, true, 0);
                System.out.println(e);
            }

            receiver.finish(true, false, nTimes);

        }
    }


