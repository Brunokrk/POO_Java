package Principal;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		int fim = -1;
		Fabrica fabrica = new Fabrica();
		Scanner s = new Scanner(System.in);
		
		do {
			System.out.println(fabrica.fabricar().info());
			System.out.println("0 interrompe, Qualquer numero continua");
			fim = s.nextInt();
		}while(fim !=0);
	}
}
