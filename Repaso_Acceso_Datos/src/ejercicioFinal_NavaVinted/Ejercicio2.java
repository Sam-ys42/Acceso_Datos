package ejercicioFinal_NavaVinted;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(escribirRandomAccess("ropa.dat") ? "se ha escrito el fichero aleatorio con éxito" : "nada");

	}

	private static boolean escribirRandomAccess(String archivoAR) {
		// TODO Auto-generated method stub
		ObjectInputStream ois1;
		try {
			// Leer archivo y almacenar en un objeto
			ois1 = new ObjectInputStream( new FileInputStream(archivoAR));
			Productos lista = (Productos) ois1.readObject();
			ois1.close();

			// Mostrar lista (comprobación)
			lista.mostrarProductos();
			
			//Crear archivo para escribir
			RandomAccessFile archivo = new RandomAccessFile("precio.dat", "rw");
			
			//Escribimos en el archivo
			for (Producto p : lista.getProductos()) {
				
				archivo.writeInt(p.getId());
				archivo.writeDouble(p.getPrecio());
				archivo.writeDouble(p.getCoste());
				archivo.writeInt(p.getDescuento());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
