package ACCESO_FICHEROS_unidad1;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class EJERCICIO6 {
 // /home/diurno/eclipse-workspace/Repaso_Acceso_Datos/FicheroTexto.txt
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Dime la ruta de un fichero: ");
		String texto = input.nextLine();
		String [] textoseparado = texto.split("/");
		File file =  new File(texto);
		if (file.exists()) {
			System.out.println("Dime el nuevo nombre que quieres qe tenga el fichero "+
					textoseparado[textoseparado.length-1]);
					
					String nuevoNombre = input.nextLine();
					
					textoseparado[textoseparado.length-1] = nuevoNombre;
					texto = "";		
					/*for (String string : textoseparado) {  //esto es un ejemplo con foreach,  el tema es que cuando meto valores en el array, el primero está vacío, pero lo cuenta
						texto = texto+"/"+ string;
					}*/
					for (int i = 1; i < textoseparado.length; i++) {
						texto = texto+ "/"+ textoseparado[i];
					}
					
					System.out.println(texto);
					File newfile = new File(texto);
					if(file.renameTo(newfile)) {
						System.out.println("Se ha cambiado el nombre por: "+ nuevoNombre);
						System.out.println(newfile.getAbsolutePath());
					}
		}
		
		
		}
	

}
