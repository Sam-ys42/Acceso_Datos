package ACCESO_FICHEROS_unidad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*Utilizando la clase empleado crea un programa que permita
 *  gestionar los empleados utilizando un fichero. El programa 
 *  debe permitir:
 *   1. Dar de alta empleados 
 *   2. Buscar empleados (a partir del dni) 
 *   3Listar empleados
 *    4Borrar empleado (por el dni)
 *     5Salir */



public class EJEMPLO27 {
	static Scanner input = new Scanner(System.in);
	static String FileName = "Empleados.bin";
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	public static void main(String[] args) {
		
		File file = new File(FileName);
	int answer ;
	
	do {
		menu();
		answer = input.nextInt();
		todo(answer, file);
	} while (answer != 5);
	
	
	}

	private static void todo(int number, File file) {
		switch (number) {
		case 1:
			CreateEmployee();
			break;
		case 2: 
			SearchEmployee();
			break;
		case 3:
			EmployeeList(file);
			break;
		case 4: 
			DeleteEmployee(file);
			

		default:
			break;
		}
		
	}

	private static void DeleteEmployee(File file) {

	}

	private static void EmployeeList(File file) {
		try {
			ois = new ObjectInputStream(new FileInputStream(FileName)) ;
			System.out.println(ois.readObject());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void SearchEmployee() {
		// TODO Auto-generated method stub
		
	}

	private static void CreateEmployee() {
		System.out.println("Introduzca los datos del empleado");
		System.out.print("dni: ");
		String dni = input.nextLine();
		input.next();
		System.out.print("nombre: ");
		String nombre = input.nextLine();
		input.next();
		System.out.print("sueldo: ");
		Double sueldo = input.nextDouble();
		Empleado employee = new Empleado(dni, nombre, sueldo);
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FileName)) ;
			oos.writeObject(employee);
			System.out.println("Objeto creado");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ois != null) {
				try {
					
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
		
	}

	public static void menu() {
		System.out.println("===MENÚ=== \n1. Dar alta empleados\n2. Buscar empleado por DNI\n3. Listar empleados\n4. Borrar empleado\n5. Salir\n================");
		
	}
	

}
