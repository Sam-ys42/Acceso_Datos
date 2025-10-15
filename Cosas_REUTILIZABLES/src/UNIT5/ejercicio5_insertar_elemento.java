package UNIT5;
import java.util.Scanner;

public class ejercicio5_insertar_elemento {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x=0, y=0, z=2;
		escribir.agregarValores(); // con esto añadimos las
									//filas y valores de la lista
		
		
		escribir.E("tiene " + escribir.array2.length+" espacios" );
		for(int i=0; i<escribir.array2.length; i++) {
			escribir.E("esto son los números: "+ escribir.array2[i]);
		}
		do {
		escribir.E("qué valor quiere cambiar?");
		int b= input.nextInt();
		escribir.E("escriba el nuevo valor");
		int c= input.nextInt();
		do {
			if(b== escribir.array2[x]) {
				y=1;
				escribir.array2[x]=c;
				break;
			}
			x++;
		}while(y==0);
		y=0; x=0;
		escribir.E("valor cambiado en la posición "+x+", estos son los nuevos valores: ");
		for(int i=0; i<escribir.array2.length; i++) {
			escribir.E("esto son los números: "+ escribir.array2[i]);
		}
			escribir.E("desea cambiar alguno más? Yes=1||No=0");
			z= input.nextInt();

		}while(z==1);
		}
	}


