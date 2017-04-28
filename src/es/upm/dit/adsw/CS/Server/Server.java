package es.upm.dit.adsw.CS.Server;

import es.upm.dit.adsw.CS.Auxiliar.Address;
import es.upm.dit.adsw.CS.Auxiliar.Internet;
import es.upm.dit.adsw.CS.Auxiliar.Packet;

import java.util.Random;

/**
 * Created by aalonso on 3/4/17.
 */

public class Server extends Thread {

    private volatile boolean running = true;

    private Internet internet;
    private Address self;

    public Server(Internet internet, Address server) {
        this.internet = internet;
        this.self     = server;
    }

    public void finish() {
        running = false;
    }

    public void run() {

        int nTimes = 20;
        Packet receivedPacket, sentPacket;
        // Initial seed
        Random random = new Random(nTimes);
        int bound = 3000;

        while(running) {
            receivedPacket = internet.receive(self);
            if (receivedPacket == null) break;
            try {
                Thread.sleep(random.nextInt(bound));
            } catch (Exception e) {
                System.out.println("Server: Unexpected exception");
            }

            System.out.println("!! Server: from: " + receivedPacket.getSender().getAddress() +
                                   " Data: " + receivedPacket.getData());

            sentPacket = new Packet(self, receivedPacket.getSender(), receivedPacket.getData());
            internet.send(sentPacket);
        }
    }
}
