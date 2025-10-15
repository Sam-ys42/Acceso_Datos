package UNIT3;

import java.util.Scanner;
public class ejemploSwitch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double resultado=0;
		System.out.println("Introduce: \n 1 para sumar \n 2 para restar \n 3 para multiplicar \n 4 para dividir \n 5 para salir sin hacer nada");
		
		switch(input.nextInt()){
		case 1: 
			System.out.println("Haz elegido sumar \n Introduce 2 números: ");
			resultado =  input.nextInt() + input.nextInt();
			break;
		
		case 2: 
			System.out.println("Haz elegido restar \n Introduce 2 números: ");
			resultado = input.nextInt() - input.nextInt();
			break;
			
		case 3: 
			System.out.println("Haz elegido multiplicar \n Introduce 2 números: ");
			resultado = input.nextInt() * input.nextInt();
			break;
			
		case 4: 
			System.out.println("Haz elegido dividir \n Introduce 2 números: ");
			resultado = input.nextDouble() / input.nextDouble();
			break;
		}
		System.out.printf("%.2f", resultado);
	}

}
