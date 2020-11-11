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

		System.out.println("-----Cadastro de Veterin�rio-----");
		while(flag == true) {
			sistema.cadastrarVeterinario();
			System.out.println("Deseja cadastrar outro veterin�rio? (1/0): ");
			escolha = Integer.parseInt(leitor.next());
			if(escolha == 0) {
				flag = false;
			}
		}
		System.out.println("--------------------------------");

		imprimeMenu();
		while(flag_2==true) {
			System.out.print("Informe a op��o::::");
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
		System.out.println("Escolha a a��o: ");
		System.out.println("1.Cadastrar Novo Veterin�rio");
		System.out.println("2.Cadastrar Endere�o de um Veterin�rio");
		System.out.println("3.Cadastrar Novo Animalzinho");
		System.out.println("4.Cadastrar Dono de um Animalzinho");
		System.out.println("5.Cadastrar Endere�o de um dono");
	}
	
	private static SistemaPetShop inicioSistema(SistemaPetShop sistema) {
		boolean flag = true;
		int escolha;

		System.out.println("-----Cadastro de Veterin�rio-----");
		while(flag == true) {
			sistema.cadastrarVeterinario();
			System.out.println("Deseja cadastrar outro veterin�rio? (1/0): ");
			escolha = Integer.parseInt(leitor.next());
			if(escolha == 0) {
				flag = false;
			}
		}
		System.out.println("--------------------------------");
		
		return sistema;
	}
}

