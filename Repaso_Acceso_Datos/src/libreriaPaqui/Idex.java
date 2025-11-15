package libreriaPaqui;

import java.awt.im.InputContext;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Idex {
	private static Libros listaLibros = new Libros();
private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//al principio creamos la lista en donde se va a guardar los libros
		
		//IMPORTANTE: DA ERROR AL PRINCIPIO
		System.out.println( (leerJson()) ?"Se ha leido el archivo json correctamente": "nada"); // como me diga ah

		int resultado;
		do {
			menu();
			resultado = input.nextInt();
			switch (resultado) {
			case 1:
				nuevoLibro();
				break;
			case 2:
				modificarlibro();
				break;
			case 3:
				borrarLibro();
				break;
			case 4:
				System.out.println("saliendo...");
				break;
			default:
				System.out.println("opción inválida"); //asiu
				break;
			}
		} while (resultado != 4);
		
		System.out.println( (escribirJson()) ?"Se ha escrito el archivo json correctamente": "nada, error"); // como me diga ah

	}
	
	private static boolean escribirJson() {
		// TODO Auto-generated method stub
		boolean resultado = false;
		try {
			ObjectMapper mapeador = new ObjectMapper(); 
 			
 			mapeador.enable(SerializationFeature.INDENT_OUTPUT); 
     				// escribir objeto en el json
 			mapeador.writeValue(new File("datosPaqui.json"), listaLibros);
			resultado = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultado;
	}

	private static void borrarLibro() {
		// TODO Auto-generated method stub
		listaLibros.mostrarLibros();
		System.out.println("Dime el isbn: ");
		input.nextLine();
		String isbn = input.nextLine();
		for (Libro libro : listaLibros.getLibros()) {
			if (libro.getIsbn().equalsIgnoreCase(isbn)) {
				listaLibros.getLibros().remove(libro);
				System.out.println("libro removido");
				return;
			}
			
		}
		System.out.println("no se ha encontrado el libro");
	}

	private static void modificarlibro() {
		// TODO Auto-generated method stub
		listaLibros.mostrarLibros();
		System.out.println("Dime el isbn: ");
		input.nextLine();
		String isbn = input.nextLine();
		for (Libro libro : listaLibros.getLibros()) {
			if (libro.getIsbn().equalsIgnoreCase(isbn)) {
				System.out.println("modifiquemos el resto de datos: ");
				System.out.println("nuevo titulo:");
				libro.setTitulo(input.nextLine());
				System.out.println("nuevo autor:");
				libro.setAutor(input.nextLine());
				System.out.println("nuevo editorial:");
				libro.setEditorial(input.nextLine());
				System.out.println("datos modificados");
				return;
			}
			
		}
		System.out.println("no se ha encontrado el libro");
		
	}

	private static boolean leerJson() {
		boolean resultado = false;
		File fichero = new File("datosPaqui.json");
		if (fichero.exists()) {
			System.out.println("Leyendo datos del fichero");
			ObjectMapper mimapper = new ObjectMapper();
			mimapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			try {
				listaLibros = mimapper.readValue(fichero, Libros.class);
				resultado = true;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			try {
				fichero.createNewFile();
				System.out.println("Fichero creado");
				resultado = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("nada para leer");
			}
		}
		
		return resultado;
	}

	private static void nuevoLibro() {
		// TODO Auto-generated method stub
		Libro libro = new Libro();
		input.nextLine();
		System.out.println("Dime el titulo");
		
		libro.setTitulo(input.nextLine());
		
		System.out.println("Dime el autor");
		libro.setAutor(input.nextLine());
		//input.nextLine();
		System.out.println("Dime el editorial");
		libro.setEditorial(input.nextLine());
	//	input.nextLine();
		System.out.println("Dime el isbn");
		libro.setIsbn(input.nextLine());
	//	input.nextLine();
		listaLibros.anadirPersona(libro);
		
		System.out.println("libro añadido");
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Menú de operaciones: \n1.- Nuevo libro\n2.-Modificar libro\n3.-Borrar libro\n4.-Salir");
	}

}
