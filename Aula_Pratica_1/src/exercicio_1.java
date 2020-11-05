/*Escreva um programa em Java, que leia 5 valores do console e logo em seguida
apresente a média desses 5 valores.
*/

import java.util.Scanner;

public class exercicio_1 {
	public static void main (String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int [] valores = new int[5];
		float media = 0;
		
		for (int i = 0; i<5; i++) {
			valores[i] = leitor.nextInt(); //Lendo os valores
			media += valores[i];
		}
		
		System.out.print("Media = "+media/5);
		
	}
}
