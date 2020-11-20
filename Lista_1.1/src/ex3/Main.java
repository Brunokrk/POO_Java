package ex3;

import java.util.Scanner;

public class Main {
	
	private static Scanner leitor = new Scanner(System.in);
	
	public static void main(String args[]) {
		Palavra word = new Palavra();
		
		System.out.println("Informe a palavra: ");
		word.setWord(leitor.nextLine());
		
		byte[] result = word.inverteString();
		System.out.println("A palavra inversa é: "+ new String(result));
		
		word.setVogalsAndConsonants();
		System.out.println("Quantidade de vogais: "+ word.vogals);
		System.out.println("Quantidade de consoantes: "+ word.consonants);
		
		System.out.print("A palavara ");
		verificaPalindromo(word);
	}

	private static void verificaPalindromo(Palavra target) {
		target.setLista();
		byte[] normal = target.getLista();
		byte[] inversa = target.inverteString();
		
		String n = new String(normal);
		String m = new String(inversa);
	
		if(n.equals(m)) {
			System.out.println("é palindromo");
		}else {
			System.out.println("não é palindromo");
		}
	}
}

