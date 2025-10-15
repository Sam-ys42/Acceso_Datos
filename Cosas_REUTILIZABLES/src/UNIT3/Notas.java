package UNIT3;

import java.util.Scanner;
public class Notas {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("introduce la nota: "); 
		int numero = input.nextInt();
		
		if(numero>=0 && numero <=4) {
			System.out.println("Insuficiente "); 
		}
		else if(numero==5 ) {
			System.out.println("Suficiente "); 
		}
		else if(numero==6) {
			System.out.println("Bien"); 
		}
		else if(numero>=7 && numero <=8) {
			System.out.println("Notable "); 
		}
		else if(numero>=9 && numero <=10) {
			System.out.println("SObresaliente "); 
		}

	}

}
