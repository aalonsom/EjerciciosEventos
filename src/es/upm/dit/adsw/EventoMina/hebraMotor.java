package es.upm.dit.adsw.EventoMina;


public class hebraMotor extends Thread{

    GestorMina gestorMina;
    EstadoMotor estadoMotor = EstadoMotor.motorParado;

    public hebraMotor(GestorMina gestorMina){
        this.gestorMina = gestorMina;
    }

    public void run(){

        while(true){
            try {
                estadoMotor = gestorMina.obtenerAccionMotor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Actuar sobre el motor
        }
    }
}