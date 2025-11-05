package ejercicio42y43;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlElementWrapper; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement
public class Libreria {
 
	private String nombre;
	private String lugar;
	private int CP;
	private ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	
	
	public Libreria(String nombre, String lugar, int cP, ArrayList<Libro> listaLibros) {
		super();
		this.nombre = nombre;
		this.lugar = lugar;
		CP = cP;
		this.listaLibros = listaLibros;
		
		
	}


	public Libreria() {
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public int getCP() {
		return CP;
	}


	public void setCP(int cP) {
		CP = cP;
	}

	@XmlElementWrapper(name = "listaLibros")
	@XmlElement(name="Libro")
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}


	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	public void anadirLibro(Libro l) {
		this.listaLibros.add(l);
	}
	public void mostrarLibros() {
		for (Libro libro : listaLibros) {
			System.out.println(libro.toString());
		}
	}
	
	

	
}
