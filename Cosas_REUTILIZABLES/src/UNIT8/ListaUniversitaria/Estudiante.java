package UNIT8.ListaUniversitaria;

import java.util.Scanner;

public class Estudiante extends Persona{
	
	private String estudio;
	private double promedio;
	
	public void establecer_datos() {
		super.establecer_datos();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce tu estudio: ");
		this.estudio = input.nextLine();
		
		System.out.println("Introduce tu promedio: ");
		this.promedio = input.nextDouble();
		
		

	}

	@Override
	public String toString() {
		return "Estudiante: ["+super.toString()+", estudio=" + estudio + ", promedio=" + promedio + "]";
	}

}
