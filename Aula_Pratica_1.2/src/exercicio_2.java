import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;

public class exercicio_2 {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		String[] people = new String[3]; //array desordenado
		String[] idade = new String[3]; //array desordenado
		String[] new_people = new String[3]; //array auxiliar
		for(int i =0; i<3; i++) {
			System.out.println("Informe o nome da pessoa: ");
			people[i] = leitor.next();
			System.out.println("Informe a idade da pessoa: ");
			idade[i] = leitor.next();
		}
		//Para comparar qual idade pertence a qual pessoa
		String A = idade[0];
		String B = idade[1];
		String C = idade[2];
		
		System.out.println("Arrays em Ordem Decrescente");
		Arrays.sort(idade, Collections.reverseOrder());

		for (int i = 0; i<3; i++) {
			if(idade[i]==A){
				new_people[i] = people[0];
			}
			if(idade[i]==B){
				new_people[i] = people[1];
			}
			if(idade[i]==C){
				new_people[i] = people[2];
			}
		}
		for (String person : new_people) {
			System.out.print(person+" ");
		}
		System.out.println();
		for (String item : idade) {
			System.out.print(item+" ");
		}
	}
}
