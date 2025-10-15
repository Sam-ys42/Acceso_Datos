package UNIT3;
import java.util.Scanner;
public class MedidasTornillo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("introduce el tamaño del tornillo (cm): "); 
		double numero = input.nextDouble();
		
		if(numero<1) {
			System.out.println(" ¿eso existe?... "); 
		}
		else if(numero>=1 && numero <3 ) {
			System.out.println(" pequeño "); 
		}
		else if(numero>=3 && numero <5) {
			System.out.println("mediano"); 
		}
		else if(numero>=5 && numero <6.5) {
			System.out.println("grande"); 
		}
		else if(numero>= 6.5 && numero <8.5) {
			System.out.println("muy grande"); 
		}

	}

}
