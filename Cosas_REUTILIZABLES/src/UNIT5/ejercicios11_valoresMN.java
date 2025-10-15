package UNIT5;
import java.util.Scanner;
public class ejercicios11_valoresMN {

	public static void main(String[] args) {
		int n,m;
		Scanner input = new Scanner(System.in);
		escribir.E("introduce un valor para N: ");
		n= input.nextInt();
		escribir.E("introduce un valor para M: ");
		m= input.nextInt();
		
		int arrayN[]= new int [n];
		for(int i =0; i<n; i++ ) {
			arrayN[i]=m;
		}
		for(int i: arrayN) {
			System.out.println(i);
		}

	}

}
