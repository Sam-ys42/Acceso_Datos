package ejercicioFInal;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// no ha dicho cuantas veces preguntamos, asi que no lo voy a  meter en un 
		Scanner input = new Scanner(System.in);
		String respuesta ="";
		do {
		
		System.out.println("introduce el dni de la persona");
		String dni = input.nextLine();
		System.out.println(buscarTelefono(dni, "teléfonos.bin")); 
		System.out.println("Desea buscar otro telefono? si | no");
		respuesta = input.nextLine();
		} while (respuesta.equalsIgnoreCase("si"));
        input.close();
		System.out.println("adios");
	}

	private static String buscarTelefono(String dni, String nombreArchivo) {
		// TODO Auto-generated method stub
		  try (RandomAccessFile archivoBin = new RandomAccessFile(nombreArchivo, "r")) {
			  
		        long numRegistros = archivoBin.length() / 13; // cada registro ocupa 24 bits, lo divido pa tener los num de registros q hay
		        
		        for (int i = 0; i < numRegistros; i++) {
		            archivoBin.seek(i * 13); //  inicio del registro 

		            // Leer los 20 bytes del DNI
		            byte[] dniBytes = new byte[9];
		            archivoBin.readFully(dniBytes);
		            String dniLeido = new String(dniBytes).trim(); // quito espacios   "

		            // Leer el teléfono (4 bytes)
		            int telefono = archivoBin.readInt();

		            // Comparar con el DNI buscado
		            if (dniLeido.equals(dni)) {
		                
		                return String.valueOf(telefono); // encontrado, devuelve el valor
		            }
		  }
		  }
		  catch (Exception e) {
			// TODO: handle exception
			  e.printStackTrace();
		}
		return "no se ha encontrado el telefono";
	}

}
