package ejercicio_27_28;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ejercicioFInal.Persona;

@XmlRootElement(name="alumnos")
public class Alumnos implements Serializable {
	private ArrayList<Alumno> alumnos = new ArrayList<>(); 

	public Alumnos() {
		
	}
    @XmlElement(name = "alumno")
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public void anadirAlumno(Alumno a) {
		this.alumnos.add(a);
	}

}
