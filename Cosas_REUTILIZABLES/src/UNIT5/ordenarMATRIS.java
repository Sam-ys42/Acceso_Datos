package UNIT5;
import java.util.Arrays;
public class ordenarMATRIS {

	public static void main(String[] args) {
		 int[][] matriz = new int[5][5];

		    //añade valores al arreglo
		    for (int i = 0; i < matriz.length; i++){ 
		        for (int j=0; j< matriz[i].length; j++) {
		            matriz[i][j] = (int) (Math.random()*10);
		        }
		    }
		    
		    extracted(matriz);
		    System.out.println();

		    //accede a cada arreglo dentro de la matriz y lo pasas a la función sort que solo admite arreglos de una dimensión.
		    for(int[] i: matriz){
		        Arrays.sort(i);
		    }
		    extracted(matriz);
		    
	}

	public static void extracted(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++){ 
		    for (int j=0; j< matriz[i].length; j++) {
		    	System.out.print(matriz[i][j] + " ");		       
		    }
		    System.out.println();
		}
		
	}

}
