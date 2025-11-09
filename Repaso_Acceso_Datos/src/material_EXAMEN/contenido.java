package material_EXAMEN;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class contenido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona1 = new Persona();
		try {
			/*- ***_Ficheros XML_***
			->con DOM (uso de memoria ordenador, hace arbol nodos)
			
			_____________DE_FICHERO_A_DOM________________________________________*/
					//1 crea factoria
				DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
					
					//2 crea DocumentBuilder con la factoria
				DocumentBuilder db = factoria.newDocumentBuilder(); 
					
					//3 Parsea documento y arbol de nodos en memoria(editable)
				Document doc = db.parse("personas.xml");  // archivo xml CON COSAS
				 //ó
				Document doc1 =db.newDocument(); // árbol vacío
				doc.setXmlVersion("1.0"); 		// version
				
				
		/*	____________DE_DOM_A_FICHERO_________________________________________
					TENEMOS NUESTRO ÁRBOL "doc" */
					//1 CREAR FUENTE
				DOMSource fuente = new DOMSource(doc);
				
					//2 crear destino
				StreamResult destino = new StreamResult(new File("FicheroXML.xml"));
				
					//3 crear transformador y meter la fuente en el destino
				Transformer t = TransformerFactory.newInstance().newTransformer();
				t.transform(fuente, destino);
				
	/*-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	 * -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	 * -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
				
			->con JAXB (convierte a xml por medio de objetos)
			_____________DE_OBJETO_A_XML___Marshal____________________________*/
					//1 crear contexto
				JAXBContext jaxbContext = JAXBContext.newInstance(Persona.class); 
				Marshaller marshaller = jaxbContext.createMarshaller();
				
					// Configuración opcional para formato legible 
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
	 				
	 				//2 Convertir objeto a XML y meter en fichero xml 
	 			marshaller.marshal(persona1, new File("fichero.xml")); 
	 			marshaller.marshal(persona1, System.out); 
					
					
		/*	____________DE_XML_A_OBJETO____Unmarshal__________________________*/
					//1 Instanciar un contexto de la clase JAXBContext con la clase RootElement 
				JAXBContext contexto = JAXBContext.newInstance(Persona.class);
				
					//2 Crear un unmarshaller  que convierte el XML en JavaBeans. 
				Unmarshaller um = contexto.createUnmarshaller(); 
				
					//Realizar la deserialización  llamando al método unmarshal del marshaller. 
				Persona miClase = (Persona) um.unmarshal(new File("coleccion.xml"));


				// IMPORTANTE: DEBE HABER UN MÉTODO PARA MOSTRAR EL OBJETO
			/*	SI TIENE NUCHOAS OBJETOS DENTRO

				Clase.mostrarClase();
				
	-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+



	- ***_Ficheros JSON_***
			->Jackson */
			
		/*	____________DE_JSON_A_OBJETO____Serializar__________________________*/
						//1 Crear un ObjectMapper 
				ObjectMapper objectMapper = new ObjectMapper(); 
				
				
				// para objetosssss
				 objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
				
						//2 Leer el archivo JSON y convertirlo a un objeto 
				Persona p = objectMapper.readValue(new File("persona.json"), Persona.class);
				// A PARTIR DE AQUI SE USAN MÉTODOS DEL OBJETO
				
				
				/*  ^ si son más de 1 objeto en el json, SE DEBE CREAR 1 CLASE DE OBJETOSSSS, Y ESTA DEBE TENER UN ARRAY DENTROOO,
				*    I   y MOSTRAR TODO EN UNS FUNCION A PARTE MOSTRARX() VOID 
				*/
				
				
				
			/*____________DE_OBJETO_A_JSON____Deserializar__________________________*/
						// crear objeto
				Persona p1=new Persona("33445566","Antonio",23); 
				
	 					//crear mapper
	 			ObjectMapper mapeador = new ObjectMapper(); 
	 			
	 			mapeador.enable(SerializationFeature.INDENT_OUTPUT); 
	     				// escribir objeto en el json
	 			mapeador.writeValue(new File("personaSalida.json"), p1);
			
			
	/*-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	 * -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	 * -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
->Jackson puede LEER Y EDITAR XML Y GUARDAR INFORMACIÓN EN JSON*/
		       	 //1 Crear el XmlMapper para leer el fichero XML 
	        XmlMapper xmlMapper = new XmlMapper(); 
	        
				 //2 Leer el XML del archivo 
	        Personas miListaDePersonas = xmlMapper.readValue(new File("Personas.xml"), Personas.class); 
				
				//3 si eso añadir cosas
			miListaDePersonas.anadir(new Persona("nombre", "apellido", 5));
			
				//4 Crear el ObjectMapper para generar el JSON 
	        ObjectMapper mapeador2 = new ObjectMapper(); 	
				
			    //5 Convertir el objeto Concesionario a JSON 
	         String stringPersonas = mapeador2.writerWithDefaultPrettyPrinter().writeValueAsString(miListaDePersonas); 
			
				//6 escribir el json en un fichero
			mapeador2.writeValue(new File("concesionario.json"), miListaDePersonas); 
//____________________________________________________________________________________
// -> tambien puede LEER Y EDITAR JSON Y GUARDAR EN XML
			
				//CREAR EL OBJECTmapper para leer el fichero Json
			ObjectMapper mapeador3 = new ObjectMapper();
			
			// leer el fichero json
			Personas personas1 = objectMapper.readValue(new File("personas.xml"), Personas.class);
			
				// Manipular datos
			personas1.anadir(new Persona("Persona", "personita", 3));
			
			// crear xmlMapper para convertir el objeto a xml
			XmlMapper xmlMapper2 = new XmlMapper();
			
			
			// convertir el objeto personas a xml
			String stringDePersonas2 = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(personas1);
			
			// escribir el xml a un fihero
			xmlMapper.writeValue(new File("personas.xml"), stringDePersonas2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
