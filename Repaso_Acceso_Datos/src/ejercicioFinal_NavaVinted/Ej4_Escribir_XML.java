package ejercicioFinal_NavaVinted;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Ej4_Escribir_XML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Leer archivo y almacenar en un objeto
		ObjectInputStream ois1;
		try {
			ois1 = new ObjectInputStream(new FileInputStream("ropa.dat"));
			Productos lista = (Productos) ois1.readObject();
			ois1.close();

			// Mostrar lista (comprobación)
			lista.mostrarProductos();

			try {
				// Crear contexto JAXB
				JAXBContext jaxbContext = JAXBContext.newInstance(Productos.class);
				Marshaller marshaller = jaxbContext.createMarshaller();
				// Configuración opcional para formato legible
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				// Convertir objeto a XML y mostrar en consola
				marshaller.marshal(lista, System.out);
				marshaller.marshal(lista, new File("ropa.xml"));
			} catch (JAXBException e) {
				e.printStackTrace();
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

	}

}
