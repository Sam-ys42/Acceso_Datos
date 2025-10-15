package UNIT5;
import java.util.Scanner;
public class ejercicio13_MaxMinMatriz {
	public static int matris [][];
	public static int aux=0;
	public static int min= 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Dime el largo de la matris: ");
		int n= input.nextInt();
		System.out.print("Dime el alto de la matris: ");
		int m= input.nextInt();
		matris = new int [n][m];
		System.out.println("Dime los  "+ (n*m)+ " números que lo forman, para buscar el min y el máx: ");
		
		cogerDatos(input, n, m);
		min=matris[0][0];
		maxmin(n, m);
		mostrarMatris(n, m);
		System.out.println(aux);
		System.out.println(min);

	}


	public static void maxmin(int n, int m) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(aux< matris[i][j] ) {
					aux=matris[i][j];
				}
				if(min> matris[i][j] ) {
					min=matris[i][j];
				}
			}
		}
	}


	public static void mostrarMatris(int n, int m) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(matris[i][j] +" ");
			}
			System.out.println();
		}
	}


	public static void cogerDatos(Scanner input, int n, int m) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				matris[i][j]= input.nextInt();
			}
		}
	}
	
}
