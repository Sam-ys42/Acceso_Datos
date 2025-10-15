package UNIT5;
import java.util.Scanner;
public class ejercicio12_METODOS_ARRAY {
	
	public static int enteros[] = new int[8]; // es global, todo el undo lo utiliza
	public static int sumatotal;
	public static void mostrarEnteros() {
		escribir.E("estos son los enteros: ");
		for( int i : enteros) {
			System.out.println(i);
		}
	}
	public static void mostrarInverso() {
		escribir.E("estos son los enteros al inverso: ");
		for(int i=7; i>-1; i--) {
			escribir.E(""+ enteros[i]);
		}
		
	}
	public static void SumaEnteros() {
		int suma=0;
		for(int i=0; i<8; i++) {
			suma= suma+enteros[i];
		}
		sumatotal=suma;
		escribir.E("la suma total de los 8 números son: "+ suma);
	}
	public static void mostrarValoresMenores(int limite) {
		escribir.E("los números menores a "+limite+" son: ");
		for( int i=0; i<8; i++) {
			if(enteros[i]<limite) {
				System.out.println(enteros[i]);
			}
			
		}
	}
	public static void mostrarValoresMayoresPromedio(int valor) {
		valor=valor/8;
		escribir.E("los valores mayores al promedio "+ valor+ " son: " );
		for( int i =0; i<8; i++) {
			if(enteros[i]> valor) {
				System.out.println(enteros[i]);
			}
	}
	}
	
	public static void main(String[] args) {
		/*Cree una aplicación que contenga un array que almacene ocho enteros.
		 *  La aplicación debe llamar a cinco métodos:
		 *  (1) muestran todos los enteros, 
		 *  (2) muestran todos los enteros en orden inverso,
		 *   (3) muestran la suma de los enteros,
		 *    (4) muestran todos los valores menores que un argumento limitante, 
		 *     (5) muestra todos los valores que son más altos que el valor promedio calculado*/
		Scanner input = new Scanner(System.in);
		System.out.println("escribe 8 valores: ");
		for(int i=0; i<8; i++) {
			enteros[i]= input.nextInt();
		}
		
		mostrarEnteros();
		mostrarInverso();
		SumaEnteros();
		escribir.E("a continuación, necesito un valor: ");
		mostrarValoresMenores(input.nextInt());
		mostrarValoresMayoresPromedio(sumatotal);
	}

}
