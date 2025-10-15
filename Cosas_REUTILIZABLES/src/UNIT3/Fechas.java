package UNIT3;
 import java.util.Scanner;
public class Fechas {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("introduce el año: "); 
		int ano = input.nextInt(), mes=0;
		boolean listo= false;
		boolean bisiesto = (ano%4 ==0) ?  true : false;

		do{
			System.out.println("introduce el mes: "); 
			mes = input.nextInt();
		}while  (mes <1 || mes>12); // 1, 3, 5, 7, 8, 10 y 12 tienen 31 días.   
		
		boolean treintaUno = (mes ==1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes ==10 || mes ==12) ? true : false;
		boolean treinta = (mes ==4 || mes == 6 || mes ==9)? true : false;
//<<<<<<< HEAD
		boolean febrero = (mes==2)? true: false;

		int ventialgo = (mes == 2 && bisiesto == true)? 29 : 28;
		do {
			System.out.println("introduce el día: ");
			int dia = input.nextInt(); 
			if(treintaUno== true && dia>0 && dia<32) {
				listo=true;
			}
			else if(treinta==true && dia >0 && dia <31) {
				listo= true;
			}
			else if (febrero== true && dia >0 && dia < (ventialgo+1) ) {
				listo= true;
			}
		} while (listo == false);
		System.out.println("perfecto!! :) ");
		
		
		
	}

}
