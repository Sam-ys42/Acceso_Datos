package UNIT5;
import java.util.Scanner;
public class ejercicio2_valor_específico {
	public static int a =0, b=0;
	public static int array[];
	public static boolean comprobar(int i) {
		int lugar = 0;
		do {
			if(i == array[lugar]) {
				return true;
			}
			lugar++;
		}while(lugar<array.length);
		return false; 
	}
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		escribir.E("cuántos valores quiere añadir al array?");
		int a = input.nextInt();
		array = new int[a];
		escribir.E("rellene los " + a +" espacios:");
		for (int i=0; i< array.length; i++) {
			array[i]= input.nextInt();
		}
		
		escribir.E("qué valor quiere comprobar si está dentro del array?");
		int b = input.nextInt();
		if(comprobar(b)) {
			escribir.E("está aquí");
		}
		else {
			escribir.E("no está bro");
		}
	}
}