package ACCESO_FICHERO_ALEATORIO;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EJERCICIO32 {

	public static void escribirProducto(RandomAccessFile archivo, int c, String n, double p, int s) {

		// Nombre de producto tiene que ocupar 20 caracteres
		if (n.length() < 20) {
			while (n.length() < 20) {
				n += " ";
			}
		}

		// Escribir los datos en el archivo binario
		try {
			archivo.writeInt(c);
			archivo.writeBytes(n);
			// archivo.writeChars(n);
			// archivo.writeUTF(n);
			archivo.writeDouble(p);
			archivo.writeInt(s);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void leerProducto(RandomAccessFile archivo, int indice) {

		try {

			// Mover el punturo del archivo a la posicion correspondiente del registro
			archivo.seek(indice * 36);
			// Leer codigo
			int codigo = archivo.readInt();
			// Leer el nombre
			byte[] nombreBytes = new byte[20];
			archivo.read(nombreBytes);
			String nombre = new String(nombreBytes);
			nombre.trim();
			// Leer el precio
			double precio = archivo.readDouble();
			// Leer la cantidad en stock
			int cantidad = archivo.readInt();
			// Mostrar los datos leidos
			System.out.println("Producto: " + codigo);
			System.out.println("Nombre: " + nombre);
			System.out.println("Precio: " + precio);
			System.out.println("Cantidad en stock: " + cantidad);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			RandomAccessFile archivo = new RandomAccessFile("productos.dat", "rw");

			// Escribimos 3 productos
			escribirProducto(archivo, 1, "Leche", 1.50, 100);
			escribirProducto(archivo, 2, "Pan", 8.75, 200);
			escribirProducto(archivo, 3, "Zumo", 15.30, 50);

			// Escribir los datos en archivo binario
			leerProducto(archivo, 1);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
