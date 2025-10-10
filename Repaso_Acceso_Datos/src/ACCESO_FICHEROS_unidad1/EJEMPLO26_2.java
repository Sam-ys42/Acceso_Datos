package ACCESO_FICHEROS_unidad1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class EJEMPLO26_2 {

Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Empleado empleado ;
		
		String nombreArchivo = "empleado.bin";
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
			empleado = (Empleado) ois.readObject();
			System.out.println("Empleado leído correctamente en el archivo .bin");
			
			System.out.println("DAtos del empleado: "+ empleado.toString());
			
		} catch (Exception e) {
		
			// TODO: handle exception
			e.printStackTrace();
		}
finally{
		if (ois != null) {
			try {
				ois.close();
				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());// TODO: handle exception
			}
		}	
			
		}
	}

}