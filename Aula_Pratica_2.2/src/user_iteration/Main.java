package user_iteration;

import dados.*;
import java.util.Scanner;

public class Main {
	private static Scanner leitor = new Scanner(System.in);
	
	public static void main(String[] args) {
		SistemaPetShop sistema = new SistemaPetShop();
		int k;
		boolean flag_2 = true;
		boolean flag = true;
		int escolha;

		System.out.println("-----Cadastro de Veterinário-----");
		while(flag == true) {
			sistema.cadastrarVeterinario();
			System.out.println("Deseja cadastrar outro veterinário? (1/0): ");
			escolha = Integer.parseInt(leitor.next());
			if(escolha == 0) {
				flag = false;
			}
		}
		System.out.println("--------------------------------");

		imprimeMenu();
		while(flag_2==true) {
			System.out.print("Informe a opção::::");
			k = leitor.nextInt();
			switch(k) {
			case 1:
				sistema.cadastrarVeterinario();
				break;
			case 2:
				sistema.cadastrarEnderecoVeterinario();
				break;
			case 3:
				sistema.cadastrarAnimal();
				break;
			case 4:
				sistema.cadastrarDono();
				break;
			case 5:
				sistema.cadastrarEnderecoDono();
			default:
				flag = false;
			}
		}
		
	}
	
	private static void imprimeMenu() {
		System.out.println("Escolha a ação: ");
		System.out.println("1.Cadastrar Novo Veterinário");
		System.out.println("2.Cadastrar Endereço de um Veterinário");
		System.out.println("3.Cadastrar Novo Animalzinho");
		System.out.println("4.Cadastrar Dono de um Animalzinho");
		System.out.println("5.Cadastrar Endereço de um dono");
	}
	
	private static SistemaPetShop inicioSistema(SistemaPetShop sistema) {
		boolean flag = true;
		int escolha;

		System.out.println("-----Cadastro de Veterinário-----");
		while(flag == true) {
			sistema.cadastrarVeterinario();
			System.out.println("Deseja cadastrar outro veterinário? (1/0): ");
			escolha = Integer.parseInt(leitor.next());
			if(escolha == 0) {
				flag = false;
			}
		}
		System.out.println("--------------------------------");
		
		return sistema;
	}
}

