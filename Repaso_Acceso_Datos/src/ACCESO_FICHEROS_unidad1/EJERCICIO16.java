package ACCESO_FICHEROS_unidad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EJERCICIO16 {

	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 int valor;
		try(BufferedReader fichero = new BufferedReader(new FileReader("hola.txt"));){
			String linea;
			ArrayList<String> array = new ArrayList<String>();
			while ((linea = fichero.readLine()) != null) {
				System.out.println(linea);
				array.add(linea);
			}
			fichero.close();
			System.out.println("Qué linea quieres borrar?");
			valor = input.nextInt();
			array.remove(valor-1);
			try (BufferedWriter newfichero = new BufferedWriter(new FileWriter("hola.txt", false))){
				for (String string : array) {
					newfichero.write(string+ "\n");
				
				}
				newfichero.close();
			} catch (Exception e) {
				e.getMessage();
				// TODO: handle exception
			}
			while ((linea = fichero.readLine()) != null) {
				System.out.println(linea);
				
			}
			
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
	}

}
