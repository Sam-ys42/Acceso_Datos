package PruebaUNIT8;
import java.util.Scanner;


public class GestionVehículos {
	static int apagar = 0;
	static int contador =0;
 final static int NUMVEHICULOS =10;
	public static void mostrarMenu() {
		System.out.print("INGRESE EL TIPO DE VEHÍCULO (A - Automovil, M - Motocicleta, C - Camión, S - Salir) :");
	}
	public static String pedirOpcion() {			
		
		Scanner leer = new Scanner(System.in);
		String cadena;
		do {											
			cadena = leer.nextLine();
		}while(!cadena.equalsIgnoreCase("A") && !cadena.equalsIgnoreCase("M") && !cadena.equalsIgnoreCase("C") && !cadena.equalsIgnoreCase("S"));
		
			return cadena;
	}
	
	
	public static void main(String[] args) {
		Vehiculo arrayVehiculos[] = new Vehiculo[NUMVEHICULOS];
		Scanner input = new Scanner(System.in);
while(apagar==0) {
			
			mostrarMenu();
			
			switch(pedirOpcion()) {
			case "A":
				
				crearAutomovil(arrayVehiculos, input);
				break;
			
			case "M":
			
				crearMotocicleta(arrayVehiculos, input);
				break;
			
			case "C":	
				
				crearCamion(arrayVehiculos, input);
				break;
				
				
			case "S":															
				
				mostrarInforme(arrayVehiculos);
				break;
				
			}
			
		}
	}
	public static void mostrarInforme(Vehiculo arrayVehiculos[]) {
	System.out.println("===== INFORME DE VEHÍCULOS =====");
			for (int i = 0; i < arrayVehiculos.length; i++) {
				
				if (arrayVehiculos[i] instanceof Automovil) {
					System.out.println(arrayVehiculos[i].mostrarInfo());
					Automovil a = (Automovil) arrayVehiculos[i];
					a.rellenarLimpiaParabrisas();
				}
				if (arrayVehiculos[i] instanceof Motocicleta) {
					
					System.out.println(arrayVehiculos[i].mostrarInfo());
				}
			}
		
		System.out.println();
			for (int i = 0; i < arrayVehiculos.length; i++) {
				
				
			}
		
		
		System.out.println();
		

			for (int i = 0; i < arrayVehiculos.length; i++) {
				
				if (arrayVehiculos[i] instanceof Camion) {
					System.out.println(arrayVehiculos[i].mostrarInfo());
				}
			}
		apagar=1;
		System.out.println("===== Fin del informe =====");
	}

	public static void crearAutomovil(Vehiculo arrayVehiculos[], Scanner input) {
		
		if (contador < NUMVEHICULOS) {
			System.out.print("Marca: ");
			String marca = input.nextLine();
			input.nextLine();
			System.out.print("Modelo: ");
			String modelo = input.nextLine();
			System.out.print("Año: ");
			int anyo = input.nextInt();
			System.out.print("Kilometraje: ");
			double kilometros = input.nextDouble();
			System.out.print("Números de puertas: ");
			int numPuertas= input.nextInt();
			Automovil automovil = new Automovil(marca, modelo, anyo,kilometros , numPuertas);
			arrayVehiculos[contador] = automovil;
			
			
			contador++;
		}else {
			System.out.println("ERROR, el número máximo de vehículos es "+NUMVEHICULOS+", no se pueden introducir más.");
		}
	}
	
public static void crearMotocicleta(Vehiculo arrayVehiculos[], Scanner input) {
		
		if (contador < NUMVEHICULOS) {
			System.out.print("Marca: ");
			String marca = input.nextLine();
			input.nextLine();
			System.out.print("Modelo: ");
			String modelo = input.nextLine();
			System.out.print("Año: ");
			int anyo = input.nextInt();
			System.out.print("Kilometraje: ");
			double kilometros = input.nextDouble();
			input.nextLine();
			System.out.print("Tipo de motor: ");
			String motor= input.nextLine();
			motor= input.nextLine();
			Motocicleta motocicleta = new Motocicleta(marca, modelo,anyo, kilometros, motor);
			arrayVehiculos[contador] = motocicleta;
			contador++;
			
		}else {
			System.out.println("ERROR, el número máximo de vehículos es "+NUMVEHICULOS+", no se pueden introducir más.");
		}
	}
	
	
public static void crearCamion(Vehiculo arrayVehiculos[], Scanner input) {
	
	if (contador < NUMVEHICULOS) {
		System.out.print("Marca: ");
		String marca = input.nextLine();
		input.nextLine();
		System.out.print("Modelo: ");
		String modelo = input.nextLine();
		input.nextLine();
		System.out.print("Año: ");
		int anyo = input.nextInt();
		System.out.print("Kilometraje: ");
		double kilometros = input.nextDouble();
		System.out.print("Capacidad de carga(toneladas): ");
		double capacidadCarga= input.nextDouble();
		Camion camion = new Camion(marca, modelo, anyo, kilometros,capacidadCarga);
		arrayVehiculos[contador] = camion;
		contador++;
		
	}else {
		System.out.println("ERROR, el número máximo de vehículos es "+NUMVEHICULOS+", no se pueden introducir más.");
	}
}
	
	
	
	
	
}
