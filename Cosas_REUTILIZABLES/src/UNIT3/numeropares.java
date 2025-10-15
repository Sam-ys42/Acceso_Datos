package UNIT3;
import java.util.Scanner;
public class numeropares {

	public static void main(String[] args) {
		Scanner inout = new Scanner(System.in);
		int n = inout.nextInt();
		for (int i=0; i<n*2; i+=2) {
			System.out.println(i);
		}
	}
}
