package UNIT7;

import java.util.Scanner;

public class A2_Eje_palindromo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String palabra="", inversa= "";
		
		palabra= input.nextLine();
		for(int i = palabra.length()-1; i>=0; i-- ) {
			inversa += palabra.charAt(i);
		}
		if(palabra.equalsIgnoreCase(inversa)) {
			System.out.println("PALINDROMO!!");
		}else {
			System.out.println(palabra+ " y " + inversa +" no lo son....");
		}
	}

}
