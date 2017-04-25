package es.upm.dit.adsw.CS.ServerConc;

/**
 * Created by aalonso on 4/4/17.
 */

import java.util.Random;
import es.upm.dit.adsw.CS.Auxiliar.*;

public class Handler extends Thread{

    // The id of the server
    private int id;
    // The order of the message received from the client
    private Internet internet;
    private Packet packet;

    public Handler(int id, Internet internet, Packet packet) {
        this.id          = id;
        this.packet      = packet;
        this.internet    = internet;
    }

    public void run() {
        Packet sentPacket;
        // Initial seed
        Random random = new Random(id);
        int bound = 10000;

        // Simulate processing time for handling the message
        System.out.println("!! Server -> Handler: " + id +
                " from: " + packet.getSender().getAddress()+ " Data: " + packet.getData());

        try {
            Thread.sleep(random.nextInt(bound));
        } catch (Exception e) {
            System.out.println("Handler: Unexpected exception");
        }

        sentPacket = new Packet(packet.getReceiver(), packet.getSender(), packet.getData());
        internet.send(sentPacket);
    }

}