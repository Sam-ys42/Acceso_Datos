package ejercicioFInal;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonIgnoreProperties(ignoreUnknown = true)

@XmlRootElement(name="personas")
public class Personas implements Serializable{
	private ArrayList<Persona> personas = new ArrayList<>(); 

	public Personas() {
		
	}
	@XmlElement(name="persona")
	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> listapersonas) {
		this.personas = listapersonas;
	}

	public void mostrarPersonas() {
        if (personas == null || personas.isEmpty()) {
            System.out.println("No hay personas en la lista");
        } else {
            for (Persona p : personas) {
                System.out.println(p);
            }
        }
    }




}
