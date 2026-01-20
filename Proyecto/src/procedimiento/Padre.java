package procedimiento;

import java.io.*;
import java.util.*;

public class Padre {

    public static void main(String[] args) throws Exception {
        int numJug = 3;
        List<Process> jugadores = new ArrayList<>();
        List<BufferedWriter> escribir = new ArrayList<>();
        List<BufferedReader> readers = new ArrayList<>();

        // Lanzar procesos hijo 
        for (int i = 0; i < numJug; i++) {
            ProcessBuilder pb = new ProcessBuilder("java", "C:/Users/ysdel/Desktop/ProyectosDAM/Acceso_Datos/Proyecto/src/procedimiento/Hijo.java");
            pb.redirectErrorStream(true);
            Process p = pb.start();

            jugadores.add(p);
            escribir.add(new BufferedWriter(new OutputStreamWriter(p.getOutputStream())));
            readers.add(new BufferedReader(new InputStreamReader(p.getInputStream())));
        }

        Thread.sleep(1550);
        System.out.println("Procesos jugador iniciados.");

        Random rand = new Random();
        Set<Integer> usedNumbers = new HashSet<>();
        boolean winnerFound = false;

        while (!winnerFound) { 
            
            for (int i = 0; i < numJug; i++) {
                BufferedReader r = readers.get(i);

                while (r.ready()) {
                    String respuesta = r.readLine();
                    System.out.println("Jugador " + i + ": " + respuesta);

                    if ("BINGO".equals(respuesta)) {
                        System.out.println("\nGANA: Jugador " + i);
                        winnerFound = true;
                    }
                }
            }

            if (winnerFound) break;  // PARA

            // Generar número nuevo
            int number;
            do {
                number = rand.nextInt(99) + 1;
                Thread.sleep(500);
            } while (usedNumbers.contains(number));

            usedNumbers.add(number);
            System.out.println("\nNúmero cantado: " + number);

            // Enviar número a todos los jugadores
            for (BufferedWriter w : escribir) {
                try {
                    w.write(Integer.toString(number));
                    w.newLine();
                    w.flush();
                } catch (IOException e) {
                    // Si un hijo ya cerró su tubería, ignoramos el error
                }
            }

            Thread.sleep(500);
        }

        // Terminar procesos
        for (Process p : jugadores) {
            p.destroy();
        }

        System.out.println("\nFin del juego.");
    }
}
