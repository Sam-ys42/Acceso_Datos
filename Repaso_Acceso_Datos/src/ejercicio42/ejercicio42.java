package ejercicio42;

import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ejercicio42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libreria miLibreria = new Libreria();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el nombre de la librería");
		miLibreria.setNombre(input.nextLine());
		System.out.println("Introduce la población");
		miLibreria.setLugar(input.nextLine());
		System.out.println("Introduce el cp");
		miLibreria.setCP(Integer.parseInt(input.nextLine()));
		
		// pido datos de los libros de esa libreria
boolean salir = false;
		
		while (salir == false) {

			System.out.println("Escriba 1 si desea añadir libro / Escriba 2 si desea salir: ");
			int valor = Integer.parseInt(input.nextLine());

			if (valor == 2) {

				System.out.println("Saliendo...\n");
				salir = true;

			} else {

				Libro l = new Libro();
				System.out.println("Introduce el titulo del libro: ");
				l.setTitulo(input.nextLine());
				System.out.println("Introduce el autor del libro: ");
				l.setAutor(input.nextLine());
				System.out.println("Introduce la editorial del libro: ");
				l.setEditorial(input.nextLine());
				System.out.println("Introduce el isbn del libro: ");
				l.setIsbn(Integer.parseInt(input.nextLine()));
				
				miLibreria.anadirLibro(l);
			}

		}
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
		
		try {
			// Crear contexto JAXB
			JAXBContext jaxbContext = JAXBContext.newInstance(Libreria.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			// Configuración opcional para formato legible
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			// Convertir objeto a XML y mostrar en consola
			marshaller.marshal(miLibreria, System.out);
			
			} catch (JAXBException e) {
			e.printStackTrace();
			}
		
		
	}

}
