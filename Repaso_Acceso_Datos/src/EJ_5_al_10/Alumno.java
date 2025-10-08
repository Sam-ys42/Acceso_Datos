package EJ_5_al_10;

import java.util.ArrayList;

public class Alumno {
	protected  int expediente;
	protected String nombre;
	protected String apellido;
	protected ArrayList<Double> notas;
	
	
	
	
	public Alumno(int expediente, String nombre, String apellido, ArrayList<Double> notas) {
		super();
		this.expediente = expediente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.notas = notas;
	}
	public int getExpediente() {
		return expediente;
	}
	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public ArrayList<Double> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}
	@Override
	public String toString() {
		return "Alumno [expediente=" + expediente + ", nombre=" + nombre + ", apellido=" + apellido + ", notas=" + notas
				+ "]";
	}
	
	
	public void anadirNota(Double nota) {
		notas.add(nota);
	}
	
	public Double calcularNotas() {
		Double total =0.0;
		for (Double double1 : notas) {
			total = total + double1;
		}
		return total/ notas.size();
	}
}
