package mis_cosas_APARTE;

public class Juego {
    private static final int FPS = 1;

    public static void main(String[] args) {
        long tiempoPorFrame = 1000 / FPS; // Milisegundos por frame
        int hola=0;
        while (true) {
            long inicio = System.currentTimeMillis();

        
            System.out.println(hola++);
            long tiempoTranscurrido = System.currentTimeMillis() - inicio;
            long tiempoEspera = tiempoPorFrame - tiempoTranscurrido;

            if (tiempoEspera > 0) {
                try {
                    Thread.sleep(tiempoEspera);  // Espera lo necesario
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

  
}