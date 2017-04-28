package es.upm.dit.adsw.CS.Auxiliar;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by aalonso on 3/4/17.
 */
public class Internet {
    private volatile boolean running = true;
    private HashMap messages  = new HashMap<Address, ArrayList<Packet>>();

    public synchronized void finish () {
        running = false;
        notifyAll();
    }

    public synchronized void send (Packet packet) {

        //System.out.println("Enter send: " + packet.getSender().getAddress());

        ArrayList<Packet> auxList;

        if (packet == null) return;

        if (packet.getSender() == null) return;

        if (messages.containsKey(packet.getReceiver())) {
            // If there are previous messages for the receiver
            auxList = (ArrayList<Packet>) messages.get(packet.getReceiver());
            auxList.add(packet);
        } else {
            // There are no pending message for the receiver
            auxList = new ArrayList<Packet>();
            auxList.add(packet);
            messages.put(packet.getReceiver(), auxList);
        }
        notifyAll();
    }

    public synchronized Packet receive (Address receiver) {

       // System.out.println("Enter receive: " + receiver.getAddress());
        ArrayList<Packet> auxList;

        while(!(messages.containsKey(receiver) || !running))
            try {
                wait();
            } catch (Exception e) {

            }

        if (!running) return null;

        auxList = (ArrayList<Packet>) messages.get(receiver);
        if (auxList.size() == 1) {
            messages.remove(receiver);
        }

        return auxList.remove(0);
    }
}
