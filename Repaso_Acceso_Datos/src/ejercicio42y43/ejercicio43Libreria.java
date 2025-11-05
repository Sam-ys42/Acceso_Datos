package ejercicio42y43;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ejercicio43Libreria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// instanciar un contexto de la clase jaxbcontent con la clase RootElement
			JAXBContext contexto = JAXBContext.newInstance(Libreria.class);
			// Crear un unmashaller que convierte el xmml en JavaBeans
			Unmarshaller um = contexto.createUnmarshaller();
			//Realizar la deserializacion llamando al metodo unmarshal del marchaller
			Libreria milibreria = (Libreria) um.unmarshal(new File("LibreriaAAAA.xml"));
			
			System.out.println("Librería "+ milibreria.getNombre() + "Población "+ milibreria.getLugar()+" "+ milibreria.getCP()+"\n");
			System.out.println("Libros disponibles: \n ");
			
			milibreria.mostrarLibros();
		} catch (JAXBException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
