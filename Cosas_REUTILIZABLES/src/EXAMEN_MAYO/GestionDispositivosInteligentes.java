package EXAMEN_MAYO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestionDispositivosInteligentes {

	 public static int mostrarMenuYPedirOpcion(Scanner input) {
			int respuesta;
			
			do {	
				System.out.print("===== MENÚ DE GESTIÓN DE DISPOSITIVOS ====="+ "\n1. Agregar nuevo dispositivo\n2. Encender un dispositivo\n3. Apagar dispositivo\n4. Modificar configuración del dispositivo \n5. Mostrar estado de todos los dispositivos \n6. Eliminar un dispositivo \n7. Salir \nSeleccione una opción: ");
				respuesta = input.nextInt();
			}while(respuesta != 1 && respuesta != 2 && respuesta != 3 && respuesta != 4 && respuesta != 5 && respuesta !=6 && respuesta != 7) ;
			
			return respuesta;
	}
	 

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);			
		 ArrayList<DispositivoInteligente> arraylist = new ArrayList<DispositivoInteligente>();	
		
		 /**
		  @author Samira
		   Aquí tienes ejemplos de dispositivos para añadir sin necesidad de perder el tiempo metiéndolos por consola :)
		   
		   
		 TermostadoInteligente t = new TermostadoInteligente("a", "casa", false, 50); 				
		 AltavozInteligente a = new AltavozInteligente("b", "casa", false, 20, false);
		 BombillaInteligente b = new BombillaInteligente("c", "casa", false, 30);
		 
		 arraylist.add(t);
		 arraylist.add(a);
		 arraylist.add(b);*/

		 boolean continuar = true; // con esta variable controlamos el bucle while para que pregunte qué quiere hacer el usuario hasta que diga que quiere salir
		 while(continuar) {
			 switch(mostrarMenuYPedirOpcion(input)) {
			 case 1:
				 Agregardispositivo(arraylist, input); // agregamos dispositivo
				 break;
			 case 2:
				  EncenderDispositivo(arraylist, input);//encender dispositivo
				 break;
			 case 3:
				 ApagarDispositivo(arraylist, input);// apagar dispositivo
				 break;
			 case 4:
				 ModificarDispositivo(arraylist, input);// modificar dispositivo
				 break;
			 case 5: 
				 MostrarInventario(arraylist, input);// estado de los dispositivos
				 break;
			 case 6: 
				 EliminarDispositivo(arraylist, input);// eliminar dispositivo
				 break;
			 case 7:
				 System.out.println("Saliendo del sistema...");
				 continuar = false;
				 break;
			 }
		 }
	}
	
	public static void ModificarDispositivo(ArrayList<DispositivoInteligente> arraylist, Scanner input) {
		Iterator<DispositivoInteligente> i = arraylist.iterator();
		DispositivoInteligente elemento;
		while (i.hasNext()) {
			String id, ubicacion, aux;
			int brillo, volumen;  double temperatura;  boolean encendido, reproduciendoMusica;
			elemento = i.next();
			if (elemento instanceof BombillaInteligente) {
				BombillaInteligente a = (BombillaInteligente) elemento;
				System.out.print("Introduzca la id: ");
				id = input.nextLine();
				System.out.print("Introduzca la ubicación: ");
				ubicacion = input.nextLine();
				System.out.print("¿Dispositivo encendido? (si / no): ");
				 aux = input.nextLine();
				 encendido =  aux.equalsIgnoreCase("si")? true : false;
				 do {
				System.out.print("Introduzca la intensidad de brillo (0 a 100): ");
				brillo = input.nextInt();
				 }
				while(brillo<0 && brillo >100);
				 a.brillo=brillo;
				 a.id=id;
				 a.encendido= encendido;
				 a.ubicacion= ubicacion;
			}
			if (elemento instanceof AltavozInteligente) {
				AltavozInteligente a = (AltavozInteligente) elemento;
				System.out.print("Introduzca la id: ");
				id = input.nextLine();
				System.out.print("Introduzca la ubicación: ");
				ubicacion = input.nextLine();
				System.out.print("¿Dispositivo encendido? (si / no): ");
				 aux = input.nextLine();
				 encendido =  aux.equalsIgnoreCase("si")? true : false;
				 System.out.println("Introduzca el volumen: ");
				 volumen= input.nextInt();
				 System.out.print("¿Dispositivo reproduciéndose? (si / no): ");
				 aux = input.nextLine();
				 reproduciendoMusica =  aux.equalsIgnoreCase("si")? true : false;
				 a.encendido= encendido;
				 a.id= id;
				 a.reproduciendoMusica= reproduciendoMusica;
				 a.ubicacion= ubicacion;
				 a.volumen= volumen;
			}
			if (elemento instanceof TermostadoInteligente) {
				TermostadoInteligente a = (TermostadoInteligente) elemento;
				System.out.print("Introduzca la id: ");
				id = input.nextLine();
				System.out.print("Introduzca la ubicación: ");
				ubicacion = input.nextLine();
				System.out.print("¿Dispositivo encendido? (si / no): ");
				 aux = input.nextLine();
				 encendido =  aux.equalsIgnoreCase("si")? true : false;
				 System.out.println("Introduzca la temperatura objetivo (Cº):");
				 temperatura= input.nextDouble();
				 a.encendido=encendido;
				 a.id=id;
				 a.ubicacion=ubicacion;
				 a.temperaturaObjetivo= temperatura;
			}
		}
	}
	private static void MostrarInventario(ArrayList<DispositivoInteligente> arraylist, Scanner input) {
		System.err.println();
		 System.out.println("===== LISTA DE DISPOSITIVOS INTELIGENTES =====");
		 System.err.println();
		 Iterator<DispositivoInteligente> i = arraylist.iterator();
			DispositivoInteligente elemento;
			while (i.hasNext()) {
				elemento = i.next();
				
				if (elemento instanceof BombillaInteligente) {
					BombillaInteligente a = (BombillaInteligente) elemento;
					System.out.println(a.mostrarInfo()); //muestra la información
				}
				if (elemento instanceof AltavozInteligente) {
					AltavozInteligente a = (AltavozInteligente) elemento;
					System.out.println(a.mostrarInfo()); //muestra la información
				}
				if (elemento instanceof TermostadoInteligente) {
					TermostadoInteligente a = (TermostadoInteligente) elemento;
					System.out.println(a.mostrarInfo()); //muestra la información
				}
			}
			System.out.println();
			System.out.println(); 
	}
	
	private static void Agregardispositivo(ArrayList<DispositivoInteligente> arraylist, Scanner input) {
		String cadena;
		do {	
			input.nextLine();
			System.out.print("INGRESE EL TIPO DE DISPOSITIVO INTELIGENTE (B - Bombilla, T - Termostato, A - Altavoz) :");
			cadena = input.nextLine();
		}while(!cadena.equalsIgnoreCase("B") && !cadena.equalsIgnoreCase("T") && !cadena.equalsIgnoreCase("A"));
		String id, ubicacion, aux;
		int brillo, volumen;  double temperatura;  boolean encendido, reproduciendoMusica;
		switch(cadena) {
		case "b":
		case "B":
			
			System.out.print("Introduzca la id: ");
			id = input.nextLine();
			System.out.print("Introduzca la ubicación: ");
			ubicacion = input.nextLine();
			System.out.print("¿Dispositivo encendido? (si / no): ");
			 aux = input.nextLine();
			 encendido =  aux.equalsIgnoreCase("si")? true : false;
			 do {
			System.out.print("Introduzca la intensidad de brillo (0 a 100): ");
			brillo = input.nextInt();
			 }
			while(brillo<0 || brillo >100);
			
			
			BombillaInteligente bomilla = new BombillaInteligente(id, ubicacion, encendido, brillo);
			arraylist.add(bomilla); // añadimos el objeto al Arraylist
			break;
			
		case "T":
		case "t":
			System.out.print("Introduzca la id: ");
			id = input.nextLine();
			System.out.print("Introduzca la ubicación: ");
			ubicacion = input.nextLine();
			System.out.print("¿Dispositivo encendido? (si / no): ");
			 aux = input.nextLine();
			 encendido =  aux.equalsIgnoreCase("si")? true : false;
			 System.out.println("Introduzca la temperatura objetivo (Cº):");
			 temperatura= input.nextDouble();
			 
			 TermostadoInteligente termostato = new TermostadoInteligente(id, ubicacion, encendido, temperatura);
			arraylist.add(termostato);
			break;
			
		case "A":
		case "a":
			System.out.print("Introduzca la id: ");
			id = input.nextLine();
			System.out.print("Introduzca la ubicación: ");
			ubicacion = input.nextLine();
			System.out.print("¿Dispositivo encendido? (si / no): ");
			 aux = input.nextLine();
			 encendido =  aux.equalsIgnoreCase("si")? true : false;
			 System.out.println("Introduzca el volumen: ");
			 volumen= input.nextInt();
			 System.out.print("¿Dispositivo reproduciéndose? (si / no): ");
			 aux = input.nextLine();
			 reproduciendoMusica =  aux.equalsIgnoreCase("si")? true : false;
			 AltavozInteligente altavoz = new AltavozInteligente(id, ubicacion, encendido, volumen, reproduciendoMusica);
			 arraylist.add(altavoz);
			 break;
			}
	}
	
	public static void EncenderDispositivo(ArrayList<DispositivoInteligente> arraylist, Scanner input) {
		String respuesta;
			input.nextLine();
			System.out.print("INGRESE EL ID DEL DISPOSITIVO INTELIGENTE ");
			respuesta = input.nextLine(); // id para identificar el objeto
			Iterator<DispositivoInteligente> i = arraylist.iterator();
			DispositivoInteligente elemento;
			boolean interruptor = true;
			while(i.hasNext()) {
				elemento = i.next();
				if (elemento.id.equalsIgnoreCase(respuesta)) {
					if (elemento instanceof BombillaInteligente) {
						BombillaInteligente a = (BombillaInteligente) elemento;
						a.EncenderDispositivo();
						System.out.println("Bombilla encendida");
						interruptor= false;
						break;
						}
					if (elemento instanceof AltavozInteligente) {
						AltavozInteligente a = (AltavozInteligente) elemento;
						a.EncenderDispositivo();
						System.out.println("Altavoz encendido");
						interruptor = false; 
						break;
					}
					if (elemento instanceof TermostadoInteligente) {
						TermostadoInteligente a = (TermostadoInteligente) elemento;
						a.EncenderDispositivo();
						System.out.println("Termostato encendido");
						interruptor= false;
						break;
					}
				}
				
			}
			if (interruptor) {
				System.out.println("No se ha encontrado el dispositivo");
			}
	}
	public static void ApagarDispositivo(ArrayList<DispositivoInteligente> arraylist, Scanner input) {
		String respuesta;
			input.nextLine();
			System.out.print("INGRESE EL ID DEL DISPOSITIVO INTELIGENTE ");
			respuesta = input.nextLine(); // id para identificar el objeto
			Iterator<DispositivoInteligente> i = arraylist.iterator();
			DispositivoInteligente elemento;
			boolean interruptor = true;
			while(i.hasNext()) {
				elemento = i.next();
				if (elemento.id.equalsIgnoreCase(respuesta)) {
					if (elemento instanceof BombillaInteligente) {
						BombillaInteligente a = (BombillaInteligente) elemento;
						a.ApagarDispositivo();
						System.out.println("Bombilla apagada");
						interruptor= false;
						break;
					}
					if (elemento instanceof AltavozInteligente) {
						AltavozInteligente a = (AltavozInteligente) elemento;
						a.ApagarDispositivo();
						System.out.println("Altavoz apagado");
						interruptor= false;
						break;
					}
					if (elemento instanceof TermostadoInteligente) {
						TermostadoInteligente a = (TermostadoInteligente) elemento;
						a.ApagarDispositivo();
						System.out.println("Termostato apagado");
						interruptor= false;
						break;
					}
				}
				
			}
			
			if (interruptor) {
				System.out.println("No se ha encontrado el dispositivo");
			}
				
			
	}
	public static void EliminarDispositivo(ArrayList<DispositivoInteligente> arraylist, Scanner input) {
		String respuesta;
			input.nextLine();
			System.out.print("INGRESE EL ID DEL DISPOSITIVO INTELIGENTE ");
			respuesta = input.nextLine(); // id para identificar el objeto
			Iterator<DispositivoInteligente> i = arraylist.iterator();
			DispositivoInteligente elemento;
			boolean interruptor = true;
			while(i.hasNext()) {
				elemento = i.next();
				if (elemento.id.equalsIgnoreCase(respuesta)) {
					i.remove();
					System.out.println("Dispositivo eliminado");
					interruptor = false;
				}
				
			}
			if (interruptor) {
				System.out.println("No se ha encontrado el dispositivo");
			}
	}
	

}
