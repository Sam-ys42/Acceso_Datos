package UNIT4;
import java.util.Scanner;
public class Ejercicio10Unit4 {
 /*Escriba una función que reciba como parámetros de entrada dos instantes de tiempo expresados en horas, minutos y segundos y
   devuelva como resultado un 1 o un 2 según el primer instante de tiempo sea anterior al segundo o viceversa.*/
	
	public static int Casual(int a, int b, int c, int h, int m, int s) {
		if(a<h|| (a==h&& b<m) || (a==h && b==m && c<s)) {
		return 1;
		}
		else {
			return 2;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a=0, b=0, c=0, d=0, e=0, f=0;
		for(int i=0; i<2; i++ ) {
			if(i==1) {Pedir.E("Ahora pondremos los valores del segundo instante de tiempo");}
			do {
				Pedir.E("Introduzca las horas, comprendidas entre 1 y 23");
				if(i==1) {d=a;}
				a= input.nextInt();
			}while (a < 1 || a>24);
			do {
				if(i==1) {e=b;}
				Pedir.E("Introduzca los minutos comprendido entre 0 y 59");
				b= input.nextInt();
			}while (a < 0 && a>59);
			
			do {
				if(i==1) {f=c;}
				Pedir.E("Introduzca los segundos comprendido entre 0 y 59");
				c= input.nextInt();
			}while (a < 0 && a>59);
		
		}
		Pedir.E("El instante de tiempo anterior es el "+ Casual(d,e,f,a,b,c));
	}
}


