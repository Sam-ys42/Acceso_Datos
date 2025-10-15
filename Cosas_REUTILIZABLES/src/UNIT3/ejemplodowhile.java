package UNIT3;
 import java.util.Scanner;
public class ejemplodowhile {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int edad ;
		do {
			System.out.println("introduce tu edad: ");	
			edad=  input.nextInt();
				
			
				
		} while (edad < 0 || edad >120);
		System.out.println("tu edad es: " + edad + " años");	
	}

}
