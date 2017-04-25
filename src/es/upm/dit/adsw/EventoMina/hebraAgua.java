package es.upm.dit.adsw.EventoMina;

import java.util.Random;

public class hebraAgua extends Thread{
    Random generador = new java.util.Random(1000);
    GestorMina gestorMina;

    public hebraAgua(GestorMina gestorMina){
        this.gestorMina = gestorMina;
    }

    public void run(){

        int nivelAgua = 0;

        while(true){
            nivelAgua = generador.nextInt (1000);
            gestorMina.notificarNivelAgua(nivelAgua);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
