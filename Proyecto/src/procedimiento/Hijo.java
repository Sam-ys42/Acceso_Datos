package procedimiento;

import java.io.*;
import java.util.*;

public class Hijo {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Set<Integer> carton = new HashSet<>();

        // Generar cartón de 15 números únicos
        while (carton.size() < 15) {
            carton.add(rand.nextInt(99) + 1);
        }

        System.out.println("Jugador iniciado con carton: " + carton);
        System.out.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            int numero = Integer.parseInt(line);

            if (carton.contains(numero)) {
                carton.remove(numero);
                System.out.println("tengo el " + numero + " , quedan " + carton.size());
                System.out.flush();
            }

            if (carton.isEmpty()) {
                System.out.println("BINGO");
                System.out.flush();
                break;
            }
        }
    }
}
