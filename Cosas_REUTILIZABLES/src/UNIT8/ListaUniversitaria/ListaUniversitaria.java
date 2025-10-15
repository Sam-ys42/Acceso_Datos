package UNIT8.ListaUniversitaria;

//import java.util.Iterator;
import java.util.Scanner;

public class ListaUniversitaria {
	
	static int apagar = 0;
	
	static int contadorP = 0;
	static int contadorE = 0;
	static int contadorF = 0;
	static int contadorES = 0;
	
	public static void mostrarMenu() {
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Selecciones una de las siguientes opciones pulsando la letra correspondiente");
		System.out.println("\nE. Empleado \nF. Docente \nES.Estudiante \nS. Salir del programa\n");
		System.out.println("--------------------------------------------------------------------------------");
		
	}
	
	public static String pedirOpcion() {			
		
		Scanner leer = new Scanner(System.in);
		String cadena;
		do {											
			System.out.println("Escoge una de las opciones: ");
			cadena = leer.nextLine();
		}while(!cadena.equalsIgnoreCase("E") && !cadena.equalsIgnoreCase("F") && !cadena.equalsIgnoreCase("ES") && !cadena.equalsIgnoreCase("S"));
		
			return cadena;
	}
	
	public static void crearEmpleado(Persona array[]) {
		
		if (contadorE < 5) {
			
			System.out.println("Introduzca los datos del empleado nº "+contadorE+1);
			
			EmpleadoUniversitario empleado = new EmpleadoUniversitario();
			array[contadorP] = empleado;
			
			array[contadorP].establecer_datos();
			
			contadorP++;
			contadorE++;
		}else {
			System.out.println("ERROR, el número máximo de empleados es de 4, no se pueden introducir más.");
		}
	}
	
	public static void crearDocente(Persona array[]) {
		
		if (contadorF < 4) {
			
			System.out.println("Introduzca los datos del docente nº "+contadorF+1);
			
			Facultad docente = new Facultad();
			array[contadorP] = docente;
			
			array[contadorP].establecer_datos();
			
			contadorP++;
			contadorF++;
		}else {
			System.out.println("ERROR, el número máximo de docentes es de 3, no se pueden introducir más.");
		}
		
	}
	
	public static void crearEstudiante(Persona array[]) {
		
		if (contadorES < 8) {
			
			System.out.println("Introduzca los datos del estudiante nº "+contadorES+1);
			
			Estudiante estudiante = new Estudiante();
			array[contadorP] = estudiante;
			
			array[contadorP].establecer_datos();
			
			contadorP++;
			contadorES++;
		}else {
			System.out.println("ERROR, el número máximo de estudiantes es de 7, no se pueden introducir más.");
		}
		
	}
	
	public static void mostrarInforme(Persona array[]) {
		
		if(contadorE == 0) {
			System.out.println("No se han introducido datos de empleados.");
		}else {
			for (int i = 0; i < array.length; i++) {
				
				if (array[i] instanceof EmpleadoUniversitario) {
					System.out.println(array[i].toString());
				}
			}
		}
		
		System.out.println();
		
		if (contadorF == 0) {
			System.out.println("No se han introducido datos de docentes");
		}else {
			for (int i = 0; i < array.length; i++) {
				
			//	if (array[i] instanceof Facultad) {
					
					System.out.println(array[i].toString());
			//	}
			}
		}
		
		System.out.println();
		
		if (contadorES == 0) {
			System.out.println("No se han introducido datos de estudiantes");
		}else {
			for (int i = 0; i < array.length; i++) {
				
				if (array[i] instanceof Estudiante) {
					System.out.println(array[i].toString());
				}
			}
		}
		apagar=1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	
		
		
		Persona arrayPersona[] = new Persona[14];
		
		while(apagar==0) {
			
			mostrarMenu();
			
			switch(pedirOpcion()) {
			case "E":
				
				crearEmpleado(arrayPersona);
				break;
			
			case "F":
			
				crearDocente(arrayPersona);
				break;
			
			case "ES":	
				
				crearEstudiante(arrayPersona);
				break;
				
				
			case "S":															
				
				mostrarInforme(arrayPersona);
				break;
				
			}
			
		}
		
	}

}