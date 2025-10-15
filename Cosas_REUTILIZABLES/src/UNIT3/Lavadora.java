package UNIT3;

import java.util.Scanner;
public class Lavadora {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("introduce el peso (kg): "); 
		double numero = input.nextDouble();
		if(numero<8) {
			System.out.println(" nivel de capacidad MíNIMO "); 
		}
		else if(numero>=8 && numero <15 ) {
			System.out.println(" nivel de capacidad MEDIO "); 
		}
		else if(numero>=15 && numero <22) {
			System.out.println("nivel de capacidad ALTO"); 
		}
		else if(numero>=22 && numero <=30) {
			System.out.println("nivel de capacidad MÁXIMO"); 
		}
		else if(numero>30) {
			System.out.println("DEMASIADO PESO"); 
		}

	}

}
