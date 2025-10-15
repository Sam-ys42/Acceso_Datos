package UNIT5;
import java.util.Scanner;
import java.util.Arrays;// esto NO ENTRA EN LOS APUNTES
public class ejercicio6_max_min {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int resultado, resultado2;
		escribir.agregarValores();
		escribir.E("vale!");
		
		Arrays.sort(escribir.array2); //ORDENAR LISTA MIN A MAX
		resultado = escribir.array2[0]; //min
		resultado2 = escribir.array2[escribir.array2.length-1];//máx
		escribir.E("min: "+ resultado);
		escribir.E("max: "+ resultado2);
		
		/*AQUI IRÁ LA EXPLICACIÓN DE ANDRÉS
		 * 
		 * 
		 */
		
	}

}
