package ACCESO_FICHEROS_unidad1;

import java.io.*;
import java.util.Scanner;

/* Utilizando la clase Empleado crea un programa que permita
 * gestionar los empleados utilizando un fichero. El programa debe permitir:
 * 1. Dar de alta empleados 
 * 2. Buscar empleados (a partir del dni) 
 * 3. Listar empleados
 * 4. Borrar empleado (por el dni)
 * 5. Salir 
 */

public class EJEMPLO27 {
	static Scanner input = new Scanner(System.in);
	static String FileName = "empleados2.bin";
	static ObjectInputStream ois;
	static ObjectOutputStream oos = null;
	static File fichero = new File(FileName);
	

	public static void main(String[] args) {
		int valor;

		do {
			menu();
			valor = Integer.parseInt(input.nextLine());
			todo(valor);
		} while (valor != 5);
	}
	

	private static void todo(int valor) {
		switch (valor) {
		case 1:
			DarAltaEmpleado();
			break;
		case 2:
			BuscarEmpleado();
			break;
		case 3:
			ListarEmpleados();
			break;
		case 4: 
			modificarFichero(fichero);
			break;
		case 5: 
			System.out.println("saliendo...");
			break;
		default:
			System.out.println(" opción no válida");
			break;
		}
	}
	
	public static void modificarFichero(File nombreArchivo) {
		if (!nombreArchivo.exists()) {
			System.out.println(" No hay empleados registrados.");
			return;
		}

		try {
			System.out.println("Introduce el dni del empleado que quiere eliminar: ");
			String dni = input.nextLine();
			boolean encontrado = false;

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
			File Ftemporal = new File("tmp.bin");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Ftemporal));

			try {
				while (true) {
					Empleado emp = (Empleado) ois.readObject();
					if (!emp.getDni().equalsIgnoreCase(dni)) {
						oos.writeObject(emp);
					} else {
						encontrado = true;
					}
				}
			} catch (EOFException e) {
				// fin de fichero
			}

			ois.close();
			oos.close();

			if (encontrado) {
				if (nombreArchivo.delete()) {
					Ftemporal.renameTo(nombreArchivo.getAbsoluteFile());
					System.out.println("Empleado eliminado correctamente");
				} else {
					System.out.println("No se puede borrar el fichero original");
				}
			} else {
				Ftemporal.delete();
				System.out.println("Empleado no encontrado");
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	private static void ListarEmpleados() {
		try {
			ois = new ObjectInputStream(new FileInputStream(FileName));
			try {
				while (true) {
					Empleado em = (Empleado) ois.readObject();
					System.out.println(em.toString());
				}
			} catch (EOFException e) {
				// fin del fichero
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void BuscarEmpleado() {
		if (!fichero.exists()) {
			System.out.println(" No hay empleados registrados");
			return;
		}

		boolean llave = false;
		try {
			ois = new ObjectInputStream(new FileInputStream(FileName));
			System.out.println("Introduce el dni del empleado a buscar: ");
			String dni = input.nextLine();
			Empleado emp;

			try {
				while (true) {
					emp = (Empleado) ois.readObject();
					if (emp.getDni().equalsIgnoreCase(dni)) {
						System.out.println("Empleado encontrado: \t " + emp.toString());
						llave = true;
					}
				}
			} catch (EOFException e) {
				// fin del fichero
			}
			ois.close();

			if (!llave) {
				System.out.println("Empleado desconocido");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void DarAltaEmpleado() {
		System.out.println("Introduce el DNI: ");
		String DNI = input.nextLine();

		System.out.println("Introduce el nombre: ");
		String nombre = input.nextLine();

		System.out.println("Introduce el salario: ");
		Double salario = Double.parseDouble(input.nextLine());

		Empleado empleado = new Empleado(DNI, nombre, salario);

		if (fichero.exists()) {
			try {
				MyObjectOutputStream myoos = new MyObjectOutputStream(new FileOutputStream(FileName, true));
				myoos.writeObject(empleado);
				myoos.close();
				System.out.println(" Se ha dado de alta al empleado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				oos = new ObjectOutputStream(new FileOutputStream(FileName, true));
				oos.writeObject(empleado);
				oos.close();
				System.out.println(" Fichero creado y empleado dado de alta");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void menu() {
		System.out.println(
				"===MENÚ=== \n1. Dar alta empleados\n2. Buscar empleado por DNI\n3. Listar empleados\n4. Borrar empleado\n5. Salir\n================");
	}
}

