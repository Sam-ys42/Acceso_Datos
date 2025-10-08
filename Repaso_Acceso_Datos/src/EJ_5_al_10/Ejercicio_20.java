package EJ_5_al_10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_20 {
// 


	public static void main(String[] args) throws Exception{
		//Escribe un programa que permita al usuario adivinar un número entre 1 y 100. 
		//El programa debe guiar al usuario diciéndole si el número es mayor o menor que el que ingresó. 
		int numeroAleatorio = (int) (Math.random()*99)+1;
		int numeroUsuario= -1;
		boolean a = true; 
		Scanner input = new Scanner(System.in);
		System.out.println(numeroAleatorio);
		
		do {
			System.out.println("Estoy pensando en un número entre el 1 y el 100");
			//-------------------------------
			do {
				try {
				numeroUsuario = input.nextInt();
				if (numeroUsuario> 100 || numeroUsuario<0) {
					throw new ArithmeticException(" Debe ser un número entre 1 y 100");
				}
				a = false;
			} catch( InputMismatchException e) {
				System.out.println("Debe meter un valor numérico");
				input.next();
			}
				catch (ArithmeticException e) {
					System.out.println(e.getMessage());
				}
			} while (a);
			//--------------------------------
			
			if(numeroUsuario<numeroAleatorio) {
				System.out.println("El número es mayor");
			}
			else if(numeroUsuario>numeroAleatorio){
				System.out.println("El número es menor");
			}
			if (numeroAleatorio== numeroUsuario) {
				System.out.println("Lo adivinaste :D");
				a= false;
				break;
			}
			a=true;
		}while(a);
		
	}

}
