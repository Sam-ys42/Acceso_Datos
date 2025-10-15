package UNIT3;

import java.util.Scanner;
public class rectángulo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Dime el alto: ");
		int alto= input.nextInt();
		System.out.print("Dime el largo: ");
		int largo= input.nextInt();
		
		for(int i=0; i<alto; i++) {
			for (int j=0; j<largo; j++){
				System.out.print("@ ");
			}
			System.out.println();
		}
		
	}

}
