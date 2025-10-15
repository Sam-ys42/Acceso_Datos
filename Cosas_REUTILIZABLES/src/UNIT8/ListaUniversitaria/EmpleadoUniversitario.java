package UNIT8.ListaUniversitaria;

import java.util.Scanner;

public class EmpleadoUniversitario extends Persona {
	
	private int numSS;
	private double salario;
	private String nomDepartamento;
	
	public void establecer_datos() {
		super.establecer_datos();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce tu número de la SS: ");
		this.numSS = input.nextInt();
		System.out.println("Introduce tu salario: ");
		this.salario = input.nextInt();
		input.nextLine();
		System.out.println("Introduce tu departamento: ");
		this.nomDepartamento = input.nextLine();
		
		

	}

	@Override
	public String toString() {
		return "EmpleadoUniversitario: ["+super.toString()+", numSS="+ numSS + ", salario=" + salario + ", nomDepartamento=" + nomDepartamento+"]";
	}

	

}