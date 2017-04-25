package es.upm.dit.adsw.CS.Client;

import es.upm.dit.adsw.CS.Auxiliar.Address;
import es.upm.dit.adsw.CS.Auxiliar.Internet;
import es.upm.dit.adsw.CS.Auxiliar.Packet;

import java.util.Random;

/**
 * Created by aalonso on 3/4/17.
 */
public class Client extends Thread{


    private   int nTimes = 5;
    private   int id;
    private Internet internet;

    private Address self, server;

    public Client(int id, Internet internet, Address self, Address server) {
        this.id = id;
        this.internet = internet;
        this.self     = self;
        this.server   = server;
    }

    public void run() {
        // Initial seed
        Random random = new Random(id);
        Packet packet;
        int bound = 8000;

        for (int i = 0; i < nTimes; i++) {
            System.out.println(">> Client: " + id + " Sent:  Sequence: " + i);
            internet.send(new Packet(self, server, "Sequence: " + i));
            packet = internet.receive(self);
            System.out.println("<< Client: " + id + " Received: " + packet.getData());
            try {
                Thread.sleep(random.nextInt(bound  ));
            } catch (Exception e) {
                System.out.println("Client: Unexpected exception");
            }
        }
    }

}
