package UNIT7;

import java.util.Scanner;

public class A3_Ejer_iniciales {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String frase=input.nextLine(), cadena2="";
		input.close();
		
		for(int i=0; i< frase.length(); i++) {
			if(i==0) {
				cadena2+= Character.toUpperCase(frase.charAt(i));
			}else {
					cadena2 +=Character.toLowerCase(frase.charAt(i));
			}
		}
		System.out.println(frase+ "\n  "+ cadena2);
		
		
		
		
	}

}
