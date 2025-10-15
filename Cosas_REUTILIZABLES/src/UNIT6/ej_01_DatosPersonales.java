package UNIT6;
import java.util.Scanner;

class Persona{
	private static String nombre;
	private static String Direccion;
	private static String edad;
	private static String  telefono;

	public Persona( ) {
		nombre= "Desconocido";
		Direccion= "Desconocido";
		edad="0";
		telefono= "Desconocido";
	}
	
	public String getNombre( ) {
		return nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public String getEdad() {
		return edad;
	}
	public String getTelefono() {
		return telefono;
	}
	
	public void setNombre(String incoming) {
		nombre = incoming;
	}
	public void setDireccion(String incoming) {
		Direccion = incoming;
	}
	public void setEdad(String incoming) {
		edad = incoming;
	}
	public void setTelefono(String incoming) {
		telefono = incoming;
	}
}
public class ej_01_DatosPersonales {
	public static int n=0;
	public static String DatosCliente[][];// NOmbe----Direccion----edad----telefono
	public static String aux[][]= new String [1][4];  
	public static String auxiliar;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Persona sujeto;
		sujeto= new Persona();
		int respu=-1;
		boolean a=true;
		
		
		do {
		do {
			System.out.println("Creamos una persona? (1=si/0=no /2= buscar personas guardadas)");
			respu=input.nextInt();
			if(respu==2) {
				mostrarNombresUsuario(input);
			}
			if(respu==0) {
				a=false;
				break;
			}
		}while(respu!=1 );
		if(respu==0) {
			a=false;
			System.out.println("Adiós :)/");
			break;
		}
		sujeto= new Persona();
		mostrarDatos(sujeto);
		System.out.println("\n ____Vamos a cambiarlos____\n__________________________");
		mostrarOpcionesCambio(input, sujeto);
		do {
		System.out.println("Desea guardar a la persona? (1=si / 0=no/ 2=ver datos)");
		respu=input.nextInt();
		if(respu==2) {mostrarDatos(sujeto);}
		
		}while(respu!=1 &&  respu!=0);
		
		if(respu==1) {
			guardarDatosArray(sujeto);
		}
		
		
		}while(a);
		
		
	}
	public static void mostrarNombresUsuario(Scanner input) {
		int b=- 1;
		if(n==0) {
			System.out.println("No hay datos guardados");
	}
		else {
			do {
			System.out.println("Selecciona alguno: ");
			for(int i=0; i< DatosCliente.length;i++) {
				System.out.println(i+ "- "+ DatosCliente[i][0]);}
			b=input.nextInt();
			}while(b<0 && b>n-1);
			
			mostrarTodosDatosUsuario( b);
			
			
		}
	}
	public static void mostrarTodosDatosUsuario(int b) { // nombre---direccion----edad-----telefono
		System.out.println("Estos son los datos de "+ DatosCliente[b][0]+ ":" );
		
			System.out.printf("-Dirección: %s \n-Edad: %s\n-Teléfono: %s\n ", DatosCliente[b][1], DatosCliente[b][2], DatosCliente[b][3]);
	}
	public static void guardarDatosArray(Persona sujeto) {
		if(n>=0) { // QUEDA POR EDIITAR ESTO, EL NOMBRE DEL 1ER USUARIO NO SE VE
			n+=1;
			DatosCliente = new String [n][4];
			auxiliar = sujeto.getNombre();
			for (int i=0; i<4; i++){
				for(int s=0; s<n-1; s++) { // S SON LOS NOMBRES EN I=0
					DatosCliente[s][i]=aux[s][i];
				}
				DatosCliente[n-1][i]=auxiliar;
				if(i==0) {
					auxiliar=sujeto.getDireccion();
				}
				else  if (i==1) {
					auxiliar= sujeto.getEdad();
				}
				else if(i==2) {
					auxiliar= sujeto.getTelefono();
				}
			}
			aux= new String[n][4];
			for (int i=0; i<4; i++){
				for(int s=0; s<n; s++) { // S SON LOS NOMBRES EN I=0
					aux[s][i]=DatosCliente[s][i];
				}   
			}
	}
}

	public static void mostrarDatos(Persona sujeto) {
		System.out.printf("||ESTOS SON SUS DATOS||\n --------------------------------- \nNombre: %s  \nEdad:  %s \nDireccion: %s \nTelefono: %s \n", sujeto.getNombre(), sujeto.getEdad(),sujeto.getDireccion(),sujeto.getTelefono());
	}
	public static void mostrarOpcionesCambio(Scanner input, Persona sujeto) {
		int respuesta=-1;
		do {
		System.out.println("Elige la opción que quieras cambiar: \n 1-Nombre\n2-Edad\n3-Dirección\n4-Teléfono\n5-Terminar Cambios");
		respuesta= input.nextInt();
		switch(respuesta){
		case 1: System.out.println("introduce el nombre: ");
		sujeto.setNombre(input.next());
		break;
		
		case 2: System.out.println("introduce la edad: ");
		sujeto.setEdad(input.next());
		break;
		
		case 3: 	System.out.println("introduce la dirección: ");
		sujeto.setDireccion(input.next());
		break;
		
		case 4: System.out.println("introduce el número de teléfono: ");
		sujeto.setTelefono(input.next());
		break;
		
		case 5: System.out.println("Datos guardados :)");
		break;

		}
		}while(respuesta !=5);
	}
}