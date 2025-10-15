package UNIT4;
import java.util.Scanner;
public class Edad {

	public static boolean esMayorEdad(int numero) {
		if (numero<18) {
			return false;
			}else {
			return true;}
	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.print("Introduzca su edad: ");
		int a= input.nextInt();
		if(esMayorEdad(a)== true) {
			System.out.print("Es mayor de edad :) \n");
		}else {
			System.out.print("No es mayor de edad :( \n");}
		main(args);
	}
}
