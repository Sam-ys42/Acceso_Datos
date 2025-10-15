package UNIT4;
import java.util.Scanner;
public class Ejercicio1Unit4 {
					 // Escribe un método Java para encontrar el número más pequeño entre tres números.
	public static int Menor(int a, int b, int c) {
		if (a<= b && a<=c) {
			return a;
		}
		else if (b<=a && b<=c) {
			return b;
		}else {
			return c;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pedir.E("Vamos a ver el menor de 3 números: ");
		Pedir.tresNumeros(0);				// He creado esta función que simplemente escribe en la consola "Dime el --- número", lo creé porque no me gusta poner tantos System.out.. para pedir siempre lo mismo :'(
		int a= input.nextInt();
		Pedir.tresNumeros (1);
		int b= input.nextInt();
		Pedir.tresNumeros(2);
		int c = input.nextInt();
		Pedir.E("El número más pequeño entre " + a+ ", "+b+" y " +c + " es: "+ Menor(a,b,c));

		
	}

}
 