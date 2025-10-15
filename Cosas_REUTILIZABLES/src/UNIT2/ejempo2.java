package UNIT2;

import java.util.Scanner; //vamo a escribir


public class ejempo2 {
	public static void main(String[] args) {
		Scanner jaimito = new Scanner(System.in); //declaramos un objeto llamado "jaimito", que nos va a ayudar a meter datos al programa :)
		System.out.println("EDAD: ");
		double edad = jaimito.nextDouble();
		System.out.println("FRECUENCIA: ");
		double frecuencia = jaimito.nextDouble();
		double fquemar = (frecuencia- edad) * 0.65;
		System.out.println(fquemar);
	}

}
