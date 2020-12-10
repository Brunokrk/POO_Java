package apresentacao;

import negocio.*;
import java.util.Scanner;
import dados.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Principal {

	private static ListaTelefonica lista = new ListaTelefonica();
	private static Scanner leitor = new Scanner(System.in);
	
	public static void main(String[]args) {
		int opcao = -1;
		
		while(opcao != 0) {
			imprimeMenu();
			opcao = Integer.parseInt(leitor.nextLine());
			switch(opcao) {
			case 0:
				break;
			case 1:
				adicionarContato();
				break;
			case 2:
				removerContato();
				break;
			case 3:
				exibirContatos();
				break;
			}
		
		}
	}
	public static void imprimeMenu() {
		System.out.println("Escolha uma opçao");
		System.out.println("0-Sair");
		System.out.println("1-Adicionar Contato");
		System.out.println("2-Remover Contato");
		System.out.println("3-Exibir Contatos");
	}
	
	public static Contato novoContato() {
		System.out.println("Informe o nome do contato");
		String nome = (leitor.nextLine());
		
		System.out.println("Informe o telefone do contato");
		int telefone = (Integer.parseInt(leitor.nextLine()));
		
		Contato contatinho = new Contato(nome, telefone);
		return contatinho;
	}
	
	public static void adicionarContato() {
		lista.adicionarContato(novoContato());
	}
	
	public static void removerContato() {
		List<Contato> apresentacao = new ArrayList<Contato>();
		
		System.out.println("Informe a primeira letra do contato");
		String letra = leitor.next();
		apresentacao = lista.buscarContatosPorLetra(letra.charAt(0));
		System.out.println(letra+": ");
		for(Contato item : apresentacao) {
			System.out.println(item.toString());
		}
		
		System.out.println("Informe o nome do usuario que deseja remover");
		String nome = leitor.nextLine();
		for(Contato item : apresentacao) {
			if(item.getNome() == nome) {
				System.out.println(item.toString()+"Removido com sucesso");
				lista.removerContato(item);
			}
		}
	}
	
	public static void exibirContatos() {
		Map<Character, List<Contato>> exibir = lista.buscarContatos();
		exibir.forEach((chave,valor) ->{
			System.out.println(chave +": ");
			for(Contato x : valor) {
				System.out.println("	"+x.toString());
			}
		});
	}
}
