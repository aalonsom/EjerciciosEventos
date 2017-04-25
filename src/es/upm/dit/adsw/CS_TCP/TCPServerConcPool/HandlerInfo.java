package es.upm.dit.adsw.CS_TCP.TCPServerConcPool;

/**
 * Created by aalonso on 2/4/17.
 */
public class HandlerInfo {

    private String message;
    private int sequence;

    public HandlerInfo(int sequence, String message) {
        this.sequence      = sequence;
        this.message = message;
    }

    public int getSequence () {
        return sequence;
    }

    public String getMessage() {
        return message;
    }

}
