package es.upm.dit.adsw.EventoMina;


public class pruebaGestorMina {

    public static void main(String[] args) {

        GestorMina  gestorMina    = new GestorMina();
        hebraMetano laHebraMetano = new hebraMetano(gestorMina);
        hebraAgua   laHebraAgua   = new hebraAgua(gestorMina);
        hebraMotor  laHebraMotor  = new hebraMotor(gestorMina);

        laHebraMetano.start();
        laHebraAgua.start();
        laHebraMotor.start();
    }
}
