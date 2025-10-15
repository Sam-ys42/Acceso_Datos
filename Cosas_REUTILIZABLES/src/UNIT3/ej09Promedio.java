package UNIT3;
import java.util.Scanner;
public class ej09Promedio {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("introduce 3 notas: "); 
		int numero = input.nextInt(), numero2= input.nextInt(), numero3= input.nextInt();
		int resultado;
		resultado= (numero+ numero2+numero3)/3;
		if(resultado >=7) {
			System.out.println("Promocina"); 
		}
		else {
			System.out.println("no promociona");
		}
		
		
	}

}
