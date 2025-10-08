package EJ_5_al_10;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio39 {

	public static void  menú() {
		System.out.println("1- Añadir Alumno. \n 2- Buscar Alumno. \n 3- Borrar Alumno. \n 4- Listar. \n 5- Salir :(. \n =========================");
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int respuesta =0;
		int clave = 6;
		// TODO Auto-generated method stub
		Map<Integer, Alumno> alumnos= new LinkedHashMap<Integer, Alumno>();
		alumnos.put(1, new Alumno(123, "Paolo", "Sánchez", new ArrayList<Double>()));
		alumnos.put(2, new Alumno(3454, "Ana", "de la Calle", new ArrayList<Double>()));
		alumnos.put(3, new Alumno(13423, "Nuria", "Carabella", new ArrayList<Double>()));
		alumnos.put(4, new Alumno(3434, "Pepe", "Núñez", new ArrayList<Double>()));
		alumnos.put(5, new Alumno(6767, "Antonio", "López", new ArrayList<Double>()));
		
		do {
			menú();
			respuesta = input.nextInt();
			
			switch (respuesta) {
			case 1:
				System.out.println("Añade: expediente numérico, nombre y apellido");
				alumnos.put(clave, new Alumno(input.nextInt(), input.next(), input.next(), new ArrayList<Double>()));
				clave = clave+1;
				
				break;
			case 2:
				System.out.println("Búscalo por su expediente: ");
				for (Map.Entry<Integer, Alumno> entry : alumnos.entrySet()) {
					Integer key = entry.getKey();
					Alumno val = entry.getValue();
					System.out.println(key + "-----"+ val.getNombre());
				}
				int valor = input.nextInt();
				System.out.println(alumnos.get(valor));
				
				break;
			case 3:
				System.out.println("Búscalo por su expediente: ");
				for (Map.Entry<Integer, Alumno> entry : alumnos.entrySet()) {
					Integer key = entry.getKey();
					Alumno val = entry.getValue();
					System.out.println(key + "-----"+ val.getNombre());
				}
				int valor2 = input.nextInt();
				alumnos.remove(valor2);
				System.out.println("Alumno exterminado");
				break;

			case 4:
				System.out.println("Esta es la lista de alumnos: ");
				for (Map.Entry<Integer, Alumno> entry : alumnos.entrySet()) {
					Integer key = entry.getKey();
					Alumno val = entry.getValue();
					System.out.println(key + "-----"+ val.toString());
				}
				break;
			case 5:
				System.out.println("Hasta luego :)");
				break;

			default:
				System.out.println("Mete un valor válido ._.");
				break;
			}
			
		} while (respuesta !=5);
		
	}

}
