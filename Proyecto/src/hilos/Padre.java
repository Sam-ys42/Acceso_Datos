package hilos;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Padre {

    private final Set<Integer> generados = new HashSet<>();
    private int ultimoNumero = -1;
    private boolean ganador = false;

    public synchronized int esperarNumero() {
        try {
            wait();
            
        } catch (InterruptedException e) {
        	
            e.printStackTrace();
            
        }
        return ultimoNumero;
    }

    public synchronized void generarNumero() {
        if (ganador) return;

        Random r = new Random();
        int num;

        do {
            num = r.nextInt(99) + 1;
        } while (generados.contains(num));

        generados.add(num);
        ultimoNumero = num;

        System.out.println("\nNúmero generado: " + num);

        notifyAll();
    }

    public synchronized void declararGanador(int id) {
        if (!ganador) {
            ganador = true;
            System.out.println("\n El jugador " + id + " ha ganado  ");
            notifyAll();
        }
    }

    public boolean hayGanador() {
        return   ganador;
    }

    public static void main(String[] args) {

        Padre controlador = new Padre();
        int numJugadores = 3;

         Hijo[] jugadores = new Hijo[numJugadores];

        for (int i = 0; i < numJugadores; i++) {
            jugadores[i] = new Hijo(i + 1, controlador);
            jugadores[i].start();
        }

        while (!controlador.hayGanador()) {
            controlador.generarNumero();

            try {
                Thread.sleep(500);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

        System.out.println("\nFin del bingo");
    }
}
