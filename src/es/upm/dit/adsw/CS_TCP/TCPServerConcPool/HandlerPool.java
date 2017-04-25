package es.upm.dit.adsw.CS_TCP.TCPServerConcPool;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by aalonso on 31/3/17.
 */
public class HandlerPool {


    private List<HandlerInfo> queue = new ArrayList<HandlerInfo>();

    public synchronized void put(HandlerInfo handlerInfo) {
        queue.add(handlerInfo);
        notifyAll();
    }

    public synchronized HandlerInfo get() {
        try {
            while (queue.size() == 0)
                wait();
        } catch (Exception E){
            System.out.println("Unexpected exception");
        }
        System.out.println(queue.size());
        return queue.remove(0);
    }
}
