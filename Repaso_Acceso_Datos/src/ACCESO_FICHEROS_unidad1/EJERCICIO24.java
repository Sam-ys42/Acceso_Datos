package ACCESO_FICHEROS_unidad1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EJERCICIO24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombreArchivo = "notasAD.bin";
		Scanner teclado = new Scanner(System.in);
		String continuar = "si";
		int numAlumnos = 0;
		
		try (FileOutputStream fos = new FileOutputStream(nombreArchivo);
				DataOutputStream dos = new DataOutputStream(fos)) {
			while (continuar.equalsIgnoreCase("si")) {
				
				// Escribir datos en binario
				System.out.println("Introduzca el numero de expediente del alumno:");
				dos.writeInt(Integer.parseInt(teclado.nextLine()));

				System.out.println("Introduzca la nota del alumno:");
				dos.writeDouble(Double.parseDouble(teclado.nextLine()));

				System.out.println("Introduzca el nombre del alumno:");
				dos.writeUTF(teclado.nextLine() + "\n");
				
				System.out.println("Si desea continuar añadiendo alumnos escriba si/no.");
				
				if (teclado.nextLine().equalsIgnoreCase("no")) {	
					continuar = "no";
				}
				numAlumnos++;
				
			}

			System.out.println("Datos escritos correctamente en " + nombreArchivo +"\n");

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try (FileInputStream fis = new FileInputStream(nombreArchivo); DataInputStream dis = new DataInputStream(fis)) {
			
			
			for (int i = 0; i < numAlumnos; i++) {
				
				// Leer los datos en el mismo orden que los escribimos
				int expediente = dis.readInt();
				double nota = dis.readDouble();
				String nombre = dis.readUTF();

				System.out.printf("Expediente: " + expediente);
				System.out.printf("     Nota: " + nota);
				System.out.printf("     Nombre: " + nombre);
			}
			


		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		
	}

}
