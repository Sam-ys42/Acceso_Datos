package ACCESO_FICHEROS_unidad1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class EjemploEscribirBinario {

	public static void main(String[] args) {
		String nombreArchivo = "datos.bin";
		try (FileOutputStream fos = new FileOutputStream(nombreArchivo)){
			DataOutputStream dos = new DataOutputStream(fos);
			// Esxrivir algunos datos binarios
			dos.writeInt(123);  	//entero
			dos.writeDouble(34.43); // double
			dos.writeBoolean(false); // boolean
			dos.writeUTF("Hola mundo"); // string en utf-8
			
			System.out.println("DAtos escritos en: "+ nombreArchivo);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
