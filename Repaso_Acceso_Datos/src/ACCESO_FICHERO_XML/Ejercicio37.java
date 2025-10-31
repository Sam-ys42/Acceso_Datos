package ACCESO_FICHERO_XML;

import java.io.File;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Ejercicio37 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeMap<Integer, String[]> ListaAlumnos = new TreeMap<>();
        String respuesta = null;

        do {
            System.out.print("Dime el expediente: ");
            int expediente = Integer.parseInt(input.nextLine());

            if (ListaAlumnos.containsKey(expediente)) {
                System.out.println("Ya existe un alumno con ese expediente.");
                continue;
            }

            System.out.print("Dime el nombre: ");
            String nombre = input.nextLine();

            System.out.print("Dime la nota: ");
            String nota = input.nextLine();

            ListaAlumnos.put(expediente, new String[]{nombre, nota});

            System.out.print("Seguimos? (s/n): ");
            respuesta = input.nextLine();

        } while (!respuesta.equalsIgnoreCase("n"));

        input.close();

        // Creamos el  documento XML
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factoria.newDocumentBuilder();
            Document documento = db.newDocument();
            documento.setXmlVersion("1.0");

            Element alumnos = documento.createElement("alumnos");
            documento.appendChild(alumnos);

            // Añadir cada alumno al XML
            for (Map.Entry<Integer, String[]> entry : ListaAlumnos.entrySet()) {
                Element alumno = documento.createElement("alumno");

                Element numExpediente = documento.createElement("numExpediente");
                numExpediente.setTextContent(String.valueOf(entry.getKey()));
                alumno.appendChild(numExpediente);

                Element nombre = documento.createElement("nombreAlumno");
                nombre.setTextContent(entry.getValue()[0]);
                alumno.appendChild(nombre);

                Element nota = documento.createElement("nota");
                nota.setTextContent(entry.getValue()[1]);
                alumno.appendChild(nota);

                alumnos.appendChild(alumno);
            }

            // Guardar en fichero
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource fuente = new DOMSource(documento);
            StreamResult fichero = new StreamResult(new File("notasAlumno.xml"));
            transformer.transform(fuente, fichero);

            System.out.println("Fichero 'notasAlumno.xml' creado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
