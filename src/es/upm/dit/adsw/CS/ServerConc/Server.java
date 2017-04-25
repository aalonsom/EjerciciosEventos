package es.upm.dit.adsw.CS.ServerConc;

import es.upm.dit.adsw.CS.Auxiliar.Address;
import es.upm.dit.adsw.CS.Auxiliar.Internet;
import es.upm.dit.adsw.CS.Auxiliar.Packet;

import java.util.Random;

/**
 * Created by aalonso on 3/4/17.
 */
public class Server extends Thread {
    private   int nTimes = 20;
    private   int id;
    private Internet internet;
    private Address self;

    public Server(Internet internet, Address server) {
        this.internet = internet;
        this.self     = server;
    }

    public void run() {

        Packet receivedPacket;
        // Initial seed
        Random random = new Random(nTimes);
        int bound = 10000;
        Handler handler;
        int id = 0;

        while(true) {
            receivedPacket = internet.receive(self);
            handler = new Handler(id, internet, receivedPacket);
            handler.start();

            id ++;
        }
    }
}
