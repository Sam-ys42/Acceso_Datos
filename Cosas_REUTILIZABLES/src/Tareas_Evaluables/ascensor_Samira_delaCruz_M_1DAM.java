package Tareas_Evaluables;
import java.util.Scanner;
public class ascensor_Samira_delaCruz_M_1DAM { // te soy sincera, acabo de descubrir esto de los "public static" ahora... pero están chulos, facilita muchísimo el trabajo
public static boolean abierto= false; // creo el valor abierto, para ver si la puerta está abierta o cerrada.
public static int respuesta, apagado=0,plantaActual=1, plantaMarcada=0, plantasPorMover; // aquí ponemos la condicional del bucle do while

	public static void marcarPlanta(int plantaMarcada) {
	// LA CHICHA YA ESTÁ EN ESTE MÉTODO----------------------------
		plantasPorMover= plantaActual-plantaMarcada;
		if(abierto== false) {
			if(plantasPorMover<0) {
				do {
					subir();
				}while(plantaActual<plantaMarcada);
				
			}
			else if (plantasPorMover > 0) {
				do {
					bajar();
				}while(plantaActual>plantaMarcada);
			}
			mostrarPanel();
		}
		//-------------------------------------- con esto nos aseguramos que la puerta está abierta (abajo)
		else {
			System.out.println("¡¡¡ATENCIÓN!!! LA PUERTA SE ENCUENTRA ABIERTA, POR FAVOR, CIERRE LA PUERTA");
			mostrarPanel();
		}
	}
	
	
	//---------------------------------------------- esto para cambiar los valores ABIERTO/CERRADO
	public static void abrirPuerta() {
		System.out.println("---Puerta abierta--- \n");
		abierto= true;
		mostrarPanel();
	}
	
	public static void cerrarPuerta() {
		System.out.println("---Puerta cerrada--- \n");
		abierto= false;
		mostrarPanel();
	}
	//-----------------------------------------------------------------------------------------
	public static void subir() {
		plantasPorMover*=-1; // esto para que no nos salga valores negativos, así tenemos las plantas x MOVER
		System.out.println("SUBIENDO");
		plantaActual +=1;
		System.out.println("((" + plantaActual+ "))");
		
		
	}
	public static void bajar() {
		System.out.println("BAJANDO");
		plantaActual -=1;
		System.out.println("((" + plantaActual+ "))");
		
	}
	
	
	public static void mostrarPanel() {
		
		System.out.println(" ((PLANTA " + plantaActual+ "))" +"\nPANEL DE CONTROL \n---------------- \n 1- Marcar planta\n 2- Abrir puerta \n 3- Cerrar Puerta  \n 4- Apagar ");
		Scanner input = new Scanner(System.in);
		respuesta = input.nextInt();
	}
	
	//-----------------------------------------------------------------------------------------
	
	// programa PRINCIPAL:--------------------------------------------
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		mostrarPanel();
		do {
			switch(respuesta) {
			case 1:  //te voy a meter un do while, para que siempre reciba el valor adecuado, y no se confunda
				do {
					System.out.println("¿A qué planta desea ir? \n0  1 \n2  3\n4  5\n");
					plantaMarcada =input.nextInt();
				}while (plantaMarcada<0 || plantaMarcada>5);
				
				marcarPlanta(plantaMarcada);
				break;
//  A PARTIR DE AQUÍ, TERMINADO, FALTA LAS PLANTAS----------------------------
			case 2:
				abrirPuerta();
				break;
				
			case 3:
				cerrarPuerta();
				break;
			case 4:
				apagado=1;
				break;
				
			}
		}while(apagado==0);
		System.out.println(" \n ----HASTA LUEGO :)----");
		

	}

}
