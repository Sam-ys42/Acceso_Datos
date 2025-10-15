package UNIT2;

import java.util.Scanner;

public class NumMasALto {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Dime la cantidad de números que quieres poner: ");
		int veces = input.nextInt();
		int matrix [];
		int resultado=0;
		matrix = new int[veces];
		for (int i =0; i< veces; i++){
			matrix [i]= input.nextInt();
		}
		for (int j=0; j<matrix.length; j++) {
				if (matrix[j] <= matrix [j+1]) {
					resultado = matrix[j];
				}
				else {
					resultado = matrix[j+1];
				}
			}
		System.out.print("esto es: "+resultado);
	}

}
