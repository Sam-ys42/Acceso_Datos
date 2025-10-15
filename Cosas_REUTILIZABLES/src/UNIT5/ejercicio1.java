package UNIT5;
import java.util.Scanner;

public class ejercicio1 {
	public static  void main(String[] args) {
    Scanner input = new Scanner(System.in);
	int valores[];
	double finale = 0;
	escribir.E("Cuántos números son?");
	int respu = input.nextInt();
	valores = new int [respu];
	for (int i = 0; i < valores.length; i++) {
	    valores[i]= input.nextInt();
	}

	for (int i = 0; i < valores.length; i++) {
	    finale += valores[i];
	}

	escribir.E(" "+ (finale/valores.length));
	}
}
