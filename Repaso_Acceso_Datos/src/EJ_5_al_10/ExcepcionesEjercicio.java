package EJ_5_al_10;

import java.util.*;

public class ExcepcionesEjercicio {
    public static void main(String[] args) {
    	
    	try {
    		  // 1. Conversión inválida de String a int
            String invalido = "abc";
            int numero = Integer.parseInt(invalido);
      		} catch ( NumberFormatException e) {
      		System.out.println("Ha habido un error, porfavor añada un valor numérico.." + e.getMessage());	
      		}
    	
    	
    	try {
            // 2. División por cero
            int resultado = 10 / 0; 
    	}catch ( ArithmeticException e) {
        		System.out.println("Ha habido un error, porfavor no divida entre 0 ..." + e.getMessage());	
    		}
            
    	
            try {
            // 3. Operación sobre variable null
            String texto = null;
            int longitud = texto.length(); 
            }
            catch (NullPointerException e) {
        		System.out.println("Ha habido un error, porfavor añada un valor a: texto. ..." + e.getMessage());	
    		}
            
            
            try {
         // 4. Acceso a índice inválido en lista
            List<String> lista = new ArrayList<>();
            lista.add("A");
            String valor = lista.get(2); 
            }
    	catch (IndexOutOfBoundsException e) {
    		System.out.println("Ha habido un error, porfavor elija un valor dentro de la lista..." + e.getMessage());	
		}
      

    
        
     

        // 5. Modificación de colección durante iteración
            try {
            List<String> nombres = new ArrayList<>();
            nombres.add("Ana");
            nombres.add("Luis");
            nombres.add("Luis");
            nombres.add("Luis");
            nombres.add("Luis");

            
            for (String nombre : nombres) {
                if (nombre.equals("Ana")) {
                    nombres.remove(nombre); 
                }
            }
            }catch (ConcurrentModificationException e) {
				System.out.println("Ha habido un error, porfavor no modifique la lista mientras se está recorriendo... "+ e.getMessage());
			}
        
        
    }
}