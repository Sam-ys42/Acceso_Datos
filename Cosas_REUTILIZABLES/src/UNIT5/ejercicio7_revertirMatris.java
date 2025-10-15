package UNIT5;
import java.util.Scanner;

public class ejercicio7_revertirMatris {

	public static void main(String[] args) {
		// vamos a meter un array, y a partir de ahí darle la vuelta
		Scanner input = new Scanner(System.in);
		escribir.agregarValores();
		int matris[] = new int[escribir.array2.length];
		int a = escribir.array2.length-1;
		for (int i=0; i< escribir.array2.length; i++) {
			matris[a]= escribir.array2[i];
			a--;
		}
		escribir.E("los numeros revertido: ");
		for (int i=0; i< escribir.array2.length; i++) {
			escribir.E(""+ matris[i]);
		}
	}

}
