package EJ_5_al_10;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce el precio del eletrodoméstico: ");
		Double precio = input.nextDouble();
		Double interes = 2.5;
		Double total = 0.0;
		System.out.println("El precio es: "+ precio);
		System.out.println("A 3 plazos con un interés de 2,5%:");
		
		Double tercio = (precio/3);
		total+= tercio+ (precio*interes/100);
		
		System.out.println("Primer plazo : "+ total );
		
		interes+=interes;
		
		
		total += tercio + ((precio-tercio)* interes /100);
		System.out.println("Segundo plazo: "+ total);
		
		interes+=interes;
		
		total += tercio + ((precio-(tercio*2))* interes /100);
		System.out.println("Tercer plazo: "+ total);
		
		System.out.println("El total a pagar es : " + total);
		
		
	}

}
