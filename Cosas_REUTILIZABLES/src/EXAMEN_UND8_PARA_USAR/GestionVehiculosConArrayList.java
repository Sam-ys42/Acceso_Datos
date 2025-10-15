package EXAMEN_UND8_PARA_USAR;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionVehiculosConArrayList {

	static int apagar = 0;
// ESTE PROGRAMA NO TIENE ÍMITE PARA AÑÑADIR
// final static int NUMVEHICULOS =10;
 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Vehiculo1> arraylist = new ArrayList<Vehiculo1>();
		
		while(apagar == 0) {// para no volver a crear código nuevo, nos ayudamos del mostrarPedir del otro ej para pedir parametros
			switch(GestionVehiculos.mostrarMenuYPedirOpcion()) {
			case "a":
			case "A":
				CrearA(arraylist, input);
				break;
			case "m":
			case "M":
				CrearB(arraylist, input);
				break;
			case "c":
			case "C":
				CrearC(arraylist, input);
				break;
			case "s":
			case "S":
				mostrarInforme(arraylist);
				break;
			}
		}

	}
	
	
	
public static void mostrarInforme(ArrayList<Vehiculo1> arraylist) {
	System.out.println("===== INFORME DE __________ =====");
	for (int i = 0; i < arraylist.size() ; i++) {
		if(arraylist.get(i) instanceof Automovil1) {
			Automovil1 a = (Automovil1) arraylist.get(i);
			System.out.println(a.mostrarInfo()); //muestra la información de _____
		}
		if(arraylist.get(i) instanceof Motocicleta1) {
			Motocicleta1 m = (Motocicleta1) arraylist.get(i);
			System.out.println(m.mostrarInfo()); //muestra la información de _____
		}
		if(arraylist.get(i) instanceof Camion1) {
			Camion1 a = (Camion1) arraylist.get(i);
			System.out.println(a.mostrarInfo()); //muestra la información de _____
		}
	}
	
	
	apagar=1;
	System.out.println("===== Fin del informe =====");
		
	}



public static void CrearA(ArrayList<Vehiculo1> arraylist, Scanner input) {
		System.out.print("Campo1: ");
		String marca = input.nextLine();
		System.out.print("Campo2: ");
		String modelo = input.nextLine();
		System.out.print("Campo3: ");
		int año = input.nextInt();
		System.out.print("Campo4: ");
		Double kilometraje = input.nextDouble();
		System.out.print("Numero de puertas: ");
		int numeroPuertas = input.nextInt();
		
		Automovil1 automovil = new Automovil1(marca, modelo, año, kilometraje, numeroPuertas);
		
		arraylist.add(automovil); // añadimos el objeto al Arraylist
}


public static void CrearB(ArrayList<Vehiculo1> arraylist, Scanner input) {
	System.out.print("Campo1: ");
	String marca = input.nextLine();
	System.out.print("Campo2: ");
	String modelo = input.nextLine();
	System.out.print("Campo3: ");
	int año = input.nextInt();
	System.out.print("Campo4: ");
	Double kilometraje = input.nextDouble();
	String tipoMotor;
	input.nextLine();
	do {
		System.out.print("Tipo de motor (2T/4T): ");
		tipoMotor = input.nextLine();
	} while (!tipoMotor.equalsIgnoreCase("2T") && !tipoMotor.equalsIgnoreCase("4T"));
	
	
	Motocicleta1 moto = new Motocicleta1(marca, modelo, año, kilometraje, tipoMotor);
	
	arraylist.add(moto); // añadimos el objeto al Arraylist
	}


public static void CrearC(ArrayList<Vehiculo1> arraylist, Scanner input) {
	System.out.print("Campo1: ");
	String marca = input.nextLine();
	System.out.print("Campo2: ");
	String modelo = input.nextLine();
	System.out.print("Campo3: ");
	int año = input.nextInt();
	System.out.print("Campo4: ");
	Double kilometraje = input.nextDouble();
	System.out.print("Campo5: ");
	int capacidadCarga = input.nextInt();
	
	Camion1 camion = new Camion1(marca, modelo, año, kilometraje, capacidadCarga);
	
	arraylist.add(camion); // añadimos el objeto al Arraylist

}


}
