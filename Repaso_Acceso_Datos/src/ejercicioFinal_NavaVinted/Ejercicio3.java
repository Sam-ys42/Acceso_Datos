package ejercicioFinal_NavaVinted;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(leerRandomAccess("precio.dat") ? "Se ha leído el archivo correctamente" : "nada");

	}

	private static boolean leerRandomAccess(String archivoRA) {
		// TODO Auto-generated method stub
		boolean resultado = false;
		System.out.println("Introduce el ID del producto: ");
		int id = Integer.parseInt(teclado.nextLine());

		try {
			RandomAccessFile archivo = new RandomAccessFile(archivoRA, "rw");

			try {

				archivo.seek(0);
				double beneficio;

				while (true) {

					if (id == archivo.readInt()) {

						double precio = archivo.readDouble();
						double coste = archivo.readDouble();
						int descuento = archivo.readInt();
						beneficio = (precio - (precio * descuento / 100) - coste);
						break;

					} else {

						archivo.skipBytes(20);

					}
				}

				System.out.println("El benificio del producto con id: " + id + " es " + beneficio);

			} catch (EOFException e) {
				// TODO: handle exception
				System.out.println("El id introducido no existe.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

}
