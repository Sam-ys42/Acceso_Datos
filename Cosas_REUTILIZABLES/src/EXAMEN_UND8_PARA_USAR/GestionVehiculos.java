package EXAMEN_UND8_PARA_USAR;
import java.util.Scanner;


public class GestionVehiculos {
	static int apagar = 0;
	static int contador =0;
 final static int NUMVEHICULOS =10;
 
 
 
 
 
//perfecto pa switch COPIAR
 
 public static String mostrarMenuYPedirOpcion() {
	 	Scanner input = new Scanner(System.in);
		String cadena;
		
		do {	
			System.out.print("INGRESE EL TIPO DE VEHÍCULO (A - Automovil, M - Motocicleta, C - Camión, S - Salir) :");
			cadena = input.nextLine();
		}while(!cadena.equalsIgnoreCase("A") && !cadena.equalsIgnoreCase("M") && !cadena.equalsIgnoreCase("C") && !cadena.equalsIgnoreCase("S"));
		
		return cadena;
}
 
 
 
 
 
 
 
 
 
 
 
 
	public static void main(String[] args) {
		Vehiculo1 arrayV[] = new Vehiculo1[NUMVEHICULOS];
		Scanner input = new Scanner(System.in);
		
while(apagar==0) {
			
			switch(mostrarMenuYPedirOpcion()) {
			case "A":
				
				crearAutomovil(arrayV, input);
				break;
			
			case "M":
			
				crearMotocicleta(arrayV, input);
				break;
			
			case "C":	
				
				crearCamion(arrayV, input);
				break;
				
				
			case "S":															
				
				mostrarInforme(arrayV);
				break;
				
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void mostrarInforme(Vehiculo1 arrayV[]) {
	System.out.println("===== INFORME DE VEHÍCULOS =====");
	for (int i = 0; i < arrayV.length; i++) {
		if (arrayV[i] instanceof Automovil1) {
			Automovil1 a = (Automovil1) arrayV[i];
			System.out.println(a.mostrarInfo());
		}
		if (arrayV[i] instanceof Motocicleta1) {
//			System.out.println(arrayV[i].mostrarInfo());
			Motocicleta1 m = (Motocicleta1) arrayV[i];
			System.out.println(m.mostrarInfo());
		}
		if (arrayV[i] instanceof Camion1) {
//			System.out.println(arrayV[i].mostrarInfo());
			Camion1 c = (Camion1) arrayV[i];
			System.out.println(c.mostrarInfo());
		}
	}
		apagar=1;
		System.out.println("===== Fin del informe =====");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void crearAutomovil(Vehiculo1 arrayV[], Scanner input) {
		
		if (contador < NUMVEHICULOS) {
			System.out.print("Marca: ");
			String marca = input.nextLine();
			System.out.print("Modelo: ");
			String modelo = input.nextLine();
			System.out.print("Año: ");
			int año = input.nextInt();
			System.out.print("Kilometraje: ");
			Double kilometraje = input.nextDouble();
			System.out.print("Numero de puertas: ");
			int numeroPuertas = input.nextInt();
			
			Automovil1 automovil = new Automovil1(marca, modelo, año, kilometraje, numeroPuertas);
			
			arrayV[contador] = automovil;
			contador++;
		}else {
			System.out.println("ERROR, el número máximo de vehículos es "+NUMVEHICULOS+", no se pueden introducir más.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public static void crearMotocicleta(Vehiculo1 arrayV[], Scanner input) {
	
		if (contador < NUMVEHICULOS) {
			System.out.print("Marca: ");
			String marca = input.nextLine();
			System.out.print("Modelo: ");
			String modelo = input.nextLine();
			System.out.print("Año: ");
			int año = input.nextInt();
			System.out.print("Kilometraje: ");
			Double kilometraje = input.nextDouble();
			String tipoMotor;
			input.nextLine();
			do {
				System.out.print("Tipo de motor (2T/4T): ");
				tipoMotor = input.nextLine();
			} while (!tipoMotor.equalsIgnoreCase("2T") && !tipoMotor.equalsIgnoreCase("4T"));
			
			Motocicleta1 motocicleta = new Motocicleta1(marca, modelo, año, kilometraje, tipoMotor);
			
			arrayV[contador] = motocicleta;
			contador++;
			
		}else {
			System.out.println("ERROR, el número máximo de vehículos es "+NUMVEHICULOS+", no se pueden introducir más.");
		}
	}























	
public static void crearCamion(Vehiculo1 arrayV[], Scanner input) {
	
	if (contador < NUMVEHICULOS) {
		System.out.print("Marca: ");
		String marca = input.nextLine();
		System.out.print("Modelo: ");
		String modelo = input.nextLine();
		System.out.print("Año: ");
		int año = input.nextInt();
		System.out.print("Kilometraje: ");
		Double kilometraje = input.nextDouble();
		System.out.print("Capacidad de carga: ");
		double capacidadCarga = input.nextDouble();
		
		Camion1 camion = new Camion1(marca, modelo, año, kilometraje, capacidadCarga);
		
		arrayV[contador] = camion;
		contador++;
	}else {
		System.out.println("ERROR, el número máximo de vehículos es "+NUMVEHICULOS+", no se pueden introducir más.");
	}
}
}
