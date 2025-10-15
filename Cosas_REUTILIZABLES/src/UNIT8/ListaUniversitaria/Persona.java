package UNIT8.ListaUniversitaria;

import java.util.Scanner;

public class Persona {
	
	
	private String nombre;
	private String apellido;
	private String direccion;
	private int codigoPostal;
	private int tlf;
	
	public void establecer_datos() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre: ");
		this.nombre = input.nextLine();
		System.out.println("Introduce tu apellido: ");
		this.apellido = input.nextLine();
		System.out.println("Introduce tu direccion: ");
		this.direccion = input.nextLine();
		System.out.println("Introduce tu codigo postal: ");
		this.codigoPostal = input.nextInt();
		System.out.println("Introduce tu tlf: ");
		this.tlf = input.nextInt();
		
		

	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", codigoPostal="
				+ codigoPostal + ", tlf=" + tlf;
	}
	

}