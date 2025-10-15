package UNIT7;
import java.util.Scanner;
public class A1_Eje_String_ValidadcionConntraseña{ // VALIDACIÓN DE UNA CONTRASEÑA

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String password; 
		boolean pasa=true;
		do {
			System.out.println("introduce la contraseña, debe contener al menos: \n -8 caracteres\n -una minuscula\n -una mayuscula\n -contiene al menos un número\n -contiene un carácter especial\n contraseña:");
			password= input.nextLine();
			pasa= comprobarContrasena(password);
				
		
		}while(pasa);
		System.out.println("perfecto ;)");
		
		
		
		
	}
 public static boolean comprobarContrasena(String password) {
	 boolean a=false, b= false, c=false, d=false, z=false;
	 if(password.length()<8) {
			z= false;
		 diferentesProblemas(0);
	 }else {
		 z=true;
	 }
	 
	 for (int i = 0; i < password.length(); i++) {
		if(Character.isUpperCase(password.charAt(i))) {
			a= true;
		}
		if(Character.isLowerCase(password.charAt(i))) {
			b= true;
		}
		if(Character.isDigit(password.charAt(i))) {
			c= true;
		}
		if(password.charAt(i)=='-' || password.charAt(i)== '_'|| password.charAt(i)=='$') {
			d= true;
		}
	}
	 if(a == false) {
		 diferentesProblemas(1);
	 }
	 if(b == false) {
		 diferentesProblemas(2);
	 }
		 if(c == false) {
				 diferentesProblemas(3);
	 }
		 if(d == false) {
			 diferentesProblemas(4);
 }
		 if(a==false || b==false || c==false || d==false || z==false) {
			 return true;
		 }else {
			 return false;
		 }
	
}
 public static void diferentesProblemas(int resultado) {
	 switch (resultado) {
	 case 0: System.out.println("La contraseña debe tener al menos 8 caracteres");
	 break;
	 case 1: System.out.println("no aparecen mayúsculas");
	 break;
	 case 2: System.out.println("no aparecen minúsculas");
	 break;
	 case 3: System.out.println("no aparece ningún número");
	 break;
	 case 4: System.out.println("no aparece ningún símbolo");
	 break;
	 }
 }
 

}
