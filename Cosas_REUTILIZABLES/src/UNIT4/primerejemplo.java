package UNIT4;
import java.util.Scanner;
public class primerejemplo { // escribe un método java para encontrar el numero mñas pequeño entre 3 números
	public static int respu(int a, int b, int c){
		if (a<=b && a<=c) {
			return a;
		}
		else if(b<=a && b<=c) {
			return b;
		}else {
			return c;
		}
	}
	public static int pedirNumero() { 		// esto es importante, con esto nos ahorramos las líneas de System para mostrar un texto repetido, 
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca un número:");
		return input.nextInt();
	}
	public static void main(String[] args) { // voy apedir numeros al usuario hasta que el usuario decida pararlo
		Scanner input = new Scanner(System.in);
		int a, b, c, answer;
		boolean definitivo = true;
		System.out.println("Vamos a encontrar el número más pequeño de 3 números:");
		do {
			a= pedirNumero();
			b= pedirNumero();
			c=pedirNumero();
			System.out.println("El número más pequeño es: "+respu(a,b,c));
			do {
				System.out.println("desea volver a empezar? 0= no/ 1= sí");
				answer = input.nextInt();
			}while(answer <0 || answer>1);
			if (answer== 0) {
				System.out.println(" Vale!!");
				definitivo= false;
			}
		}while(definitivo == true);

	}

}
