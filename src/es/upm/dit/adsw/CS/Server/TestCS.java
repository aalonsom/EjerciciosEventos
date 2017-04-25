package es.upm.dit.adsw.CS.Server;

import es.upm.dit.adsw.CS.Auxiliar.Address;
import es.upm.dit.adsw.CS.Auxiliar.Internet;
import es.upm.dit.adsw.CS.Client.Client;
import es.upm.dit.adsw.CS.Server.Server;

/**
 * Created by aalonso on 4/4/17.
 */
public class TestCS {

    public static void main(String[] args) {

        Internet internet = new Internet();
        int nClients = 4;
        Client[] clients = new Client[nClients];
        Address serverAddress = new Address("Server");

        Server server = new Server(internet, serverAddress);
        server.start();

        for (int i = 0; i < nClients; i++) {
            clients[i] = new Client(i, internet, new Address ("Client" + i), serverAddress);
            clients[i].start();
        }

        for (int i = 0; i < nClients; i++) {
            try {
                clients[i].join();
            } catch (Exception e){
                System.out.println("TestCS: Unexpented exception");
            }
        }
        internet.finish();
        server.finish();
    }

}