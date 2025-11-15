package libreriaPaqui;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="libros")

public class Libros {
private ArrayList<Libro> libros = new ArrayList<Libro>();

public Libros(ArrayList<Libro> libros) {
	super();
	this.libros = libros;
}

public Libros() {
}

public ArrayList<Libro> getLibros() {
	return libros;
}

public void setLibros(ArrayList<Libro> libros) {
	this.libros = libros;
}

public void mostrarLibros() {
    if (libros == null || libros.isEmpty()) {
        System.out.println("No hay personas en la lista");
    } else {
        for (Libro p : libros) {
            System.out.println(p);
        }
    }
}

public void anadirPersona(Libro p) {
	this.libros.add(p);
	
}




}
