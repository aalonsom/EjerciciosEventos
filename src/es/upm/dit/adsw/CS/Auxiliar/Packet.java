package es.upm.dit.adsw.CS.Auxiliar;

/**
 * Created by aalonso on 3/4/17.
 */
public class Packet {



    private Address sender;
    private Address receiver;
    private String data;

    public Packet (Address sender, Address receiver, String data) {
        this.sender   = sender;
        this.receiver = receiver;
        this.data     = data;
    }

    public Address getSender() {
        return sender;
    }

    public void setSender(Address sender) {
        this.sender = sender;
    }

    public Address getReceiver() {
        return receiver;
    }

    public void setReceiver(Address receiver) {
        this.receiver = receiver;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }





}
