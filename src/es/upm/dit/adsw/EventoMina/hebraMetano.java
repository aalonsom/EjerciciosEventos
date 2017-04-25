package es.upm.dit.adsw.EventoMina;

import java.util.Random;

public class hebraMetano extends Thread{

    Random generador = new java.util.Random(1000);
    GestorMina gestorMina;

    public hebraMetano(GestorMina gestorMina){
        this.gestorMina = gestorMina;
    }

    public void run(){

        int nivelMetano = 0;

        while(true){
            nivelMetano = generador.nextInt (200);
            gestorMina.notificarNivelMetano(nivelMetano);

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}



