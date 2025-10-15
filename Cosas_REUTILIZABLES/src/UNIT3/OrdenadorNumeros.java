package UNIT3;
import java.util.Scanner;
public class OrdenadorNumeros {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numero1= input.nextInt();
		int numero2 = input.nextInt();
		if (numero1 > numero2) {
			System.out.println(numero1 + " " + numero2);
		}
		else {
			System.out.println(numero2 + " " + numero1);
		}
	}

}
