package ejercicioFinal_NavaVinted;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ej1_CSV_a_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Productos ListaP = new Productos();

		try {
			// Abrir fichero CSV
			BufferedReader bf = new BufferedReader(
					new FileReader("ropa.csv"));

			// Variable para lectura
			String linea;

			// Bucle para leer
			while ((linea = bf.readLine()) != null) {

				String[] textoSeparado = linea.split(";");

				Producto p = new Producto();
				p.setId(Integer.parseInt(textoSeparado[0]));
				p.setNombre(textoSeparado[1]);
				p.setTalla(textoSeparado[3]);
				p.setColor(textoSeparado[4]);
				p.setStock(Integer.parseInt(textoSeparado[6]));
				p.setPrecio(Double.parseDouble(textoSeparado[7]));
				p.setCoste(Double.parseDouble(textoSeparado[8]));
				p.setEstado(textoSeparado[9]);
				p.setDescuento(Integer.parseInt(textoSeparado[10]));

				ListaP.annadirProducto(p);

			}

			// Imprimir la lista de productos 
			ListaP.mostrarProductos();

			// Guardamos la lista en un fichero binario
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ropa.dat", true));
			oos.writeObject(ListaP);
			oos.close();

			System.out.println("Lista almacenada correctamente.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
