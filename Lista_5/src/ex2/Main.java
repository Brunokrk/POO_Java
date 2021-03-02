package ex2;

import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner(System.in);
	private static Fila<Pessoa> fila = new Fila<Pessoa>(5);
	
	
	public static void main(String[] args) {
		int op=0;
		
		while(true) {
			op = menu();
			if(op == 1) {
				//inserir pessoa
				System.out.println("Informe o nome da pessoa:");
				Pessoa p = new Pessoa();
				p.setNome(s.nextLine());
				fila.add(p);
				fila.printFila();
			}else if(op == 2){
				//retirar pessoa
				Pessoa p = fila.tirar();
				fila.printFila();
			}else if(op == -1) {
				System.out.println("Finalizando...");
				break;
			}
		}

	}
	
	public static int menu() {
		System.out.println("Informe a opção");
		System.out.println("	 1 -Inserir Pessoa");
		System.out.println("	 2 -Retirar Pessoa");
		System.out.println("	-1 -Sair");
		System.out.print("::::::::::::::");
		System.out.println("");
		
		return Integer.parseInt(s.nextLine());
	}

}
