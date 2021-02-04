package iteration;

import java.util.Scanner;
import dados.Pessoa;
import negocio.Sistema;

public class Main {
	private static Sistema sistema = new Sistema();
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao = -1;
		while(opcao!=0) {
			imprimeMenu();
			System.out.print("Informe a opção::::");
			opcao = s.nextInt();
			switch(opcao) {
				case 0:
					break;
				case 1:
					sistema.adicionarPessoa(novaPessoa());
					break;
				case 2:
					sistema.removerPessoa(escolherPessoa());
					break;
				case 3:
					mostrarPessoas();
					break;
				default:
					System.out.println("Numero inválido");
			}
		}
	}
	
	private static Pessoa novaPessoa() {
		Pessoa p = new Pessoa();
		System.out.println("Digite o nome:");
		p.setNome(s.next());
		System.out.println("Digite o idade:");
		p.setIdade(s.nextInt());
		System.out.println("Digite o altura:");
		p.setAltura(s.nextFloat());
		System.out.println("Digite o massa:");
		p.setMassa(s.nextFloat());
		
		return p;
	}

	private static void mostrarPessoas() {
		for(int i = 0; i < sistema.getLista().size(); i++) {
			System.out.println("Pessoa" + i);
			System.out.println(sistema.getLista().get(i));
			System.out.println();
		}
	}
	
	private static Pessoa escolherPessoa() {
		mostrarPessoas();
		System.out.println("Escolha uma pessoa");
		int escolha = s.nextInt();
		if(escolha < sistema.getLista().size()) {
			return sistema.getLista().get(escolha);
		}else {
			return null;
		}
	}
	
	public static void imprimeMenu() {
		System.out.println("Escolha uma operação");
		System.out.println("0 - Sair");
		System.out.println("1 - Cadastrar Pessoa");
		System.out.println("2 - Remover Pessoa");
		System.out.println("3 - Mostrar Pessoa");
	}
}
