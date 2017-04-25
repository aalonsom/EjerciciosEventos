package es.upm.dit.adsw.EventoMina;

public class GestorMina {

    private static final int umbralSuperiorAgua   = 700;
    private static final int umbralInferiorAgua   = 200;
    private static final int umbralSuperiorMetano = 150;



    private int     nivelAgua            = 0;
    private int     nivelMetano          = 0;
    private EstadoMotor estadoMotor      = EstadoMotor.motorParado;
    private EstadoMotor nuevoEstadoMotor = EstadoMotor.motorParado;


    private EstadoMotor comprobarAccionMotor (EstadoMotor estadoMotor)
    {
        EstadoMotor nuevoEstadoMotor = estadoMotor;

        switch (estadoMotor) {
            case motorParado:
                if (nivelAgua > umbralSuperiorAgua && nivelMetano <= umbralSuperiorMetano) {
                    notify();
                    nuevoEstadoMotor = EstadoMotor.motorFuncionando;
                }

            case motorFuncionando: {
                if (nivelAgua < umbralInferiorAgua || nivelMetano > umbralSuperiorMetano) {
                    notify();
                    nuevoEstadoMotor = EstadoMotor.motorParado;
                }
            }
        }
        return nuevoEstadoMotor;
    }

    public  synchronized void notificarNivelAgua (int nivelAgua)
    {
        this.nivelAgua = nivelAgua;
        System.out.println("                             Nivel Agua: " + nivelAgua );
        nuevoEstadoMotor = comprobarAccionMotor (nuevoEstadoMotor);

    }

    public  synchronized void notificarNivelMetano(int nivelMetano)
    {
        this.nivelMetano = nivelMetano;
        System.out.println("           Nivel Metano: " + nivelMetano );
        nuevoEstadoMotor = comprobarAccionMotor (nuevoEstadoMotor);
    }

    public  synchronized EstadoMotor obtenerAccionMotor() throws InterruptedException
    {
        //  Hay que comprobar de nuevo las condiciones por que puede que hayan cambiado
        //  las condiciones de la mina desde que se cambio el estado del motor hasta que
        //  la hebra que controle el motor contin�e con la ejecuci�n de este m�todo.
        //  Realizar las comprobaciones previamente, reduce los cambios de contexto. S�lo
        //  ejecutar� la hebra motor cuando se haya producido al menos un cambio.



//		if (motorParado)
//		{
//			while (nivelAgua < umbralSuperiorAgua || nivelMetanoElevado) wait();
//			motorParado = false;
//		}
//		else{
//			while (nivelAgua < umbralInferiorAgua && nivelElevadoMetano) wait();
//			motorParado = true;
//		}
        try {
            while (estadoMotor == nuevoEstadoMotor) wait();
        } catch (Exception e) {
            throw e;
        }
        estadoMotor = nuevoEstadoMotor;
        System.out.println("Nuevo Estado Motor: " + estadoMotor);
        return estadoMotor;
    }
}
