package PruebaUNIT9;
import java.util.Scanner;

import java.util.ArrayList;//	 importamos la librería de arraylist
import java.util.Iterator;

public class GestionDispositivos { // cuando quieras introducir valores double, usa la coma ","

	 public static int mostrarMenuYPedirOpcion(Scanner input) {
			int respuesta;
			
			do {	
				System.out.print("===== MENÚ DE GESTIÓN DE DISPOSITIVOS ====="+ "\n1. Agregar dispositivo\n2. Aplicar descuento\n3. Mostrar dispositivos\n4. Salir\nSeleccione una opción: ");
				respuesta = input.nextInt();
			}while(respuesta != 1 && respuesta != 2 && respuesta != 3 && respuesta != 4 && respuesta != 5);
			
			return respuesta;
	}
//	 POSIBLE FUNCION PARA USAR
	 public static void mostrarInventario(ArrayList<Dispositivo> arraylist) {
		 System.err.println();
		 System.out.println("===== LISTA DE DISPOSITIVOS=====");
		 System.err.println();
		 Iterator<Dispositivo> i = arraylist.iterator();
			Dispositivo elemento;
			
			while (i.hasNext()) {
				elemento = i.next();
				if(elemento instanceof Telefono) {
					Telefono a = (Telefono) elemento;
					System.out.println(a.mostrarInfo()); //muestra la información de el teléfono
				}
				if(elemento instanceof Laptop) {
					Laptop m = (Laptop) elemento;
					System.out.println(m.mostrarInfo()); //muestra la información de el telefono
				}
				if(elemento instanceof Tablet) {
					Tablet a = (Tablet) elemento;
					System.out.println(a.mostrarInfo()); //muestra la información de _____
				}
				
			}
			 System.out.println();
	 }
//	 ---------------------------------------------------------------------------

	 public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 ArrayList<Dispositivo> arraylist = new ArrayList<Dispositivo>();
		 boolean continuar = true; // con esta variable controlamos el bucle while para que pregunte qué quiere hacer el usuario hasta que diga que quiere salir
		 while(continuar) {
			 switch(mostrarMenuYPedirOpcion(input)) {
			 case 1:
				 Agregardispositivo(arraylist, input); // agregamos dispositivo
				 break;
			 case 2:
				 AplicarDescuento(input); // función para aplicar el descuento a todos los dispositivos
				 break;
			 case 3:
				 mostrarInventario(arraylist); // mostramos el inventario
				 break;
			 case 4:
				 System.out.println("Saliendo del sistema...");
				 continuar = false;
				 break;

			 }
			 
		 }
	 }
public static void AplicarDescuento(Scanner input) {
	System.out.print("Ingrese el porcentaje de descuento: ");
		int descuento = input.nextInt();
		
		Dispositivo.descuento = descuento;
		System.out.println("Descuento aplicado a todos los dispositivos");
		
	}
	//	 -----------------------------------------------
	private static void Agregardispositivo(ArrayList<Dispositivo> arraylist, Scanner input) {
		String cadena;
		do {	
			input.nextLine();
			System.out.print("INGRESE EL TIPO DE DISPOSITIVO (T - Teléfono, L - Laptop, P - Tablet) :");
			cadena = input.nextLine();
		}while(!cadena.equalsIgnoreCase("T") && !cadena.equalsIgnoreCase("L") && !cadena.equalsIgnoreCase("P"));
		String marca, modelo;
		int camaras;  double precio, pantalla;  boolean lapizOptico;
		switch(cadena) {
		case "t":
		case "T":
			
			System.out.print("Marca: ");
			marca = input.nextLine();
			System.out.print("Modelo: ");
			modelo = input.nextLine();
			System.out.print("Precio: ");
			 precio = input.nextDouble();
			System.out.print("Cantidad de cámaras: ");
			camaras = input.nextInt();
			
			Telefono telefono = new Telefono(marca, modelo, precio, camaras);
			arraylist.add(telefono); // añadimos el objeto al Arraylist
			break;
		
		case "l":
		case "L":
		
			System.out.print("Marca: ");
			marca = input.nextLine();
			System.out.print("Modelo: ");
			modelo = input.nextLine();
			System.out.print("Precio: ");
			precio = input.nextDouble();
			System.out.print("Tamaño de la pantalla: ");
			pantalla = input.nextDouble();
			
			Laptop laptop = new Laptop(marca, modelo, precio, pantalla);
			arraylist.add(laptop); // añadimos el objeto al Arraylist
			break;
		case "p":
		case "P":	
			System.out.print("Marca: ");
			marca = input.nextLine();
			System.out.print("Modelo: ");
			modelo = input.nextLine();
			System.out.print("Precio: ");
			precio = input.nextDouble();
			System.out.print("Lápiz Óptico: ");
			lapizOptico = input.nextBoolean();
			
			Tablet tablet = new Tablet(marca, modelo, precio, lapizOptico);
			arraylist.add(tablet);
			
			break;
			
			
			
		}
		System.out.println("Dispositivo agregado correctamente :)");
		
	}
	 

	
}
