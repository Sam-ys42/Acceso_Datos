package ACCESO_FICHEROS_unidad1;

import java.io.File;

import java.util.Scanner;


public class EJERCICIO8 {
static String a = "";
static String b = "";
static int veces =0;
public static void main(String[] args) {

Scanner input = new Scanner(System.in);
System.out.print("Introduce la ruta de la carpeta: ");
String texto = input.nextLine();
System.out.println("Contenido de la carpeta: "+ texto);

try {
File file = new File(texto);

explorar(file, texto);
System.out.println("hola");
System.out.println("Hola?");


} catch (Exception e) {
e.getMessage();
}
}

public static void explorar(File file, String texto) {
boolean llave = false;

File cosa2 = new File(texto);

for (File elemento : cosa2.listFiles()) { // recorre si el file tiene directorios
if (elemento.isDirectory()) {
llave = true;

}
//System.out.println(elemento + "escaneando.....");
}



for (int i = 0; i < cosa2.listFiles().length; i++) {
File relleno;
if(llave) { //hay algun directorio
relleno = cosa2.listFiles()[i];
//System.out.println("Voy a hablar de esto: "+relleno);
//System.out.println(texto);
if(!relleno.equals(texto) && veces>1) {
if(veces>0) {
a="";
veces = veces - 1;
//System.out.println(veces +";(");
for (int j = 0; j < veces; j++) {
a += "   ";
veces = veces - 1;

//System.out.println("resto");
}
}

}
System.out.println(a+tipo(relleno)+ " "+ relleno.getName() + " ; "+ veces + " HAY CARPETA PUTA ");

if(cosa2.listFiles()[i].isDirectory()) {
File nolose = cosa2.listFiles()[i];
texto = texto+"/"+ nolose.getName();

a += "    ";
veces +=1;

explorar(cosa2, texto);
}

if(!relleno.equals(texto) && llave== false) {
if(veces>0) {
a="";
veces = veces - 1;
for (int j = 0; j < veces; j++) {
a += "   ";
veces = veces - 1;

//System.out.println("resto");
}
}

}

}
else {

relleno = cosa2.listFiles()[i];
// System.out.println(relleno +"ya no hay na ");
System.out.println(a+tipo(relleno)+ " "+ relleno.getName() + " ; "+ veces );

}
//C:\Users\ysdel\Desktop\---CLASES FP---
//C:\Prueba
texto= relleno.getParent();

}
}

public static String tipo(File tipo) {
String valor = (tipo.isDirectory())? "D": "F";
return "["+valor+"]";
}


}
