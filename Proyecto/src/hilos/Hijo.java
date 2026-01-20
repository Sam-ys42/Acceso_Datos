package hilos;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Hijo extends Thread {

    private  int id;
    private  Set<Integer> carton;
    private  Padre controlador;
    private boolean ganador = false;

    public Hijo(int id, Padre controlador) {
        this.id = id;
        this.controlador = controlador;
        this.carton = generarCarton();
    }
    

    private Set<Integer> generarCarton() {
        Set<Integer> nums = new HashSet<>();
        Random r = new Random();
        
        while (nums.size() < 15) {
            nums.add(r.nextInt(99) + 1);
        }
        return nums;
    }
    
    

    @Override
    public void run() {
        while (!ganador && !controlador.hayGanador()) {

            int numero = controlador.esperarNumero();

            if (carton.contains(numero)) {
            	
                 carton.remove(numero);
                System.out.println("Jugador " + id + " tiene el número " + numero  + "\nespacios restantes: " + carton.size());

                if (carton.isEmpty()) {
                    ganador = true;
                    controlador.declararGanador(id);
                }
            }
        }
    }
}

