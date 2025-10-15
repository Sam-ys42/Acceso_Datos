package UNIT3;
import java.util.Scanner;
public class NumeroCapicua {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("introduce 1 número para ver si es capicúa: "); 
		int numero = input.nextInt();
		int aux = numero, cifra, inverso=0;
		if(numero <10) { 
			System.out.println(" el número es capicúa");  
		}
		while(aux !=0) {
			cifra = aux%10; 
			inverso = inverso *10+ cifra;
			aux = aux /10; 
		}
		if(numero == inverso) {                           
			System.out.println(" el número es capicúa");
		}
		else {
			System.out.println(" el número NO es capicúa");
		}

	}
}
