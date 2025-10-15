package UNIT5;
import java.util.Scanner;
public class ejercioMATRICES {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int matris [][]= new int [4][4];
		
		meterValores(input, matris);
   
		mostrarMatris(matris);
		
		int aux=0;
      //  int aux[]=new int[matris.length];
		for(int i =0 ; i<matris.length; i++) {
			aux=matris[0][i];
			matris[0][i]=matris[3][i];
			matris[3][i]=aux;
		}
		System.out.println();
		mostrarMatris(matris);
		
	}

	public static void mostrarMatris(int[][] matris) {
		for(int i=0; i< 4; i++) {
			for (int j=0; j<4;j++) {
				System.out.print(matris[i][j]+ " ");
			}
			System.out.println();
		}
	} 

	public static void meterValores(Scanner input, int[][] matris) {
		for(int i=0; i< 4; i++) {
			for (int j=0; j<4;j++) {
				matris[i][j]= input.nextInt();
			}
		}
	}

}
