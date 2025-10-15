package UNIT4;
import java.util.Scanner;
public class mediaFuncion {

	public static double PedirNumero(){
		Scanner inputFuncion= new Scanner(System.in);
		System.out.println("Introduzca un numero");
		return inputFuncion.nextDouble();
	}
	
	public static double Media(double x, double y, double z) {
		double Final= (x+y+z)/3;
		return Final;
	}
	
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		double a= PedirNumero(), b= PedirNumero(), c= PedirNumero();
		System.out.printf("La media es de: %.2f \n", Media(a,b,c));

	}

}
