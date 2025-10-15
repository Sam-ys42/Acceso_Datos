package UNIT7;

import java.util.Scanner;

public class A4_Ejer_contadorPalabras {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String frase=input.nextLine();
		int contador=0;
		
		input.close();
		for (int i = 0; i < frase.length(); i++) {
			if(frase.charAt(i)!= ' ') {
				contador ++;
			}
		}
		System.out.println("hay "+ contador + " letras");
	}

}
