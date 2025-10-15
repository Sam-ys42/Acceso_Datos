package UNIT3;
 import java.util.Scanner;
public class parimpar {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numero = input.nextInt();
		 if (numero%2 ==0) {
			 System.out.println("El número " + numero + " es par");
		 }
		 else {
			 System.out.println("El número " + numero + " es impar");

		 }
	}

}
