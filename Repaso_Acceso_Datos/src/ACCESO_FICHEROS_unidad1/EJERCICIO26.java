package ACCESO_FICHEROS_unidad1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class EJERCICIO26 {

	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Empleado e1 = new Empleado("34343434Q","Mateo", 23.23);
		
		String nombreArchivo = "empleado.bin";
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
			oos.writeObject(e1);
			System.out.println("Empleado escrito correctamente en el archivo .bin");
			
			System.out.println("DAtos escritos en: "+ nombreArchivo);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
