package UNIT2;

import java.util.Scanner;



public class AreaCircunferencia {

static double PI= 3.14; 

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.print("Introduce el radio: ");
		int r= input.nextInt();
		double area =  PI* (r*r), perimetro = PI*2*r;
		System.out.printf("El área de la circunferencia es de: %.2f unidades. \n", area);
		System.out.printf("El perímetro de la circunferencia es de: %.2f unidades. \n",perimetro);
	}

}
