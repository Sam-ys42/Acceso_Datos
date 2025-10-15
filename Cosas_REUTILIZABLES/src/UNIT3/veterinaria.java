package UNIT3;                     //los he hecho 2 en 1 pq me da pereza hacer 2 programas xd
									// if i write it in this...?
import java.util.Scanner;

public class veterinaria {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double descuento = 0.08, aux=0, precio=0;
		String respu;
		int analisis=0;
		
		do {
			System.out.println("Dime el tipo de análisis:(1, 2, 3) ");
			 analisis= input.nextInt();
		}while (analisis <1 || analisis >3);
		switch (analisis){
		case 1: precio= 25.00 ;
			break;
		case 2: precio= 36.00;
			break;
		case 3: precio= 50.00;
			break;
		}
		do {
			System.out.println("¿Eres cliente afiliado? (si/no) ");
			respu= input.next();
		} while(!respu.equals("si") && !respu.equals("no") );
		
		if(respu.equals("si")) {
			aux=precio;
		}
		System.out.println("Vale, serán: " + (precio- (aux*descuento) +"€") );
	}

}
