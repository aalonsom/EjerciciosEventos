package es.upm.dit.adsw.CS_TCP.TCPServerConcPool;

import java.util.Random;

/**
 * Created by aalonso on 31/3/17.
 */

public class Handler extends Thread{

    // The id of the server
    private int id;
    // The order of the message received from the client
    private int sequence;
    private String message;
    private Sender sender;
    private HandlerInfo handlerInfo;
    private HandlerPool handlerPool;

    public Handler(int id, HandlerPool handlerPool, Sender sender) {
        this.id          = id;
        this.sender      = sender;
        this.handlerPool = handlerPool;
    }

    public void run() {
        Random random = new Random();
        int bound = 10;

        while (true) {
            // Simulate processing time for handling the message
            try {
                handlerInfo = handlerPool.get();
                System.out.println(">> Socket: " + id + " Sequence: " + handlerInfo.getSequence());
                Thread.sleep(random.nextInt(bound) * 1000);
                sender.send(handlerInfo);
                //counter.Add()
            } catch (InterruptedException e) {
            }
        }
        //try {
        //    connection.close();
        //} catch (Exception e) {
        //    return;
        //}

    }

}
