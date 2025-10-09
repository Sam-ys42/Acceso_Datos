package ACCESO_FICHEROS_unidad1;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class EjemploLeerBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombreArchivo = "datos.bin";
		
		try (FileInputStream fis = new FileInputStream(nombreArchivo)){
			DataInputStream  dis = new DataInputStream(fis);
			
			//Leeer  los datos en el mismo orden que los escribimos
			int numero = dis.readInt();
			double decimal =  dis.readDouble();
			boolean buleano = dis.readBoolean();
			String texto = dis.readUTF();
			
			System.out.println(numero + "\n"+ decimal + "\n"+ buleano + "\n"+ texto);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
