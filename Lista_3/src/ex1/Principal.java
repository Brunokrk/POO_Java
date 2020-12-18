package ex1;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Principal {
	//Obs: Em aula professor afirmou que o uso de arquivos era apenas sugestão
	private static Scanner leitor = new Scanner(System.in);
	private static List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private static double totPessoas=0;
	
	public static void main(String[] args) {
		
		
		while(true) {
			System.out.println("Deseja informar uma pessoa?(-1 para sair)");
			int flag = Integer.parseInt(leitor.nextLine());
			if(flag == -1) {
				break;
			}
			novaPessoa();
			mostraLista();
		}
	}
	
	public static void novaPessoa() {
		Pessoa pessoa = new Pessoa();
		System.out.println("Informe o nome");
		pessoa.setNome(leitor.nextLine());
		System.out.println("Informe o CPF");
		pessoa.setCpf(leitor.nextLine());
		System.out.println("Informe a Cidade");
		pessoa.setCidade(leitor.nextLine());
		System.out.println("Informe a idade");
		pessoa.setIdade(Integer.parseInt(leitor.nextLine())); 
		
		listaPessoas.add(pessoa);
		System.out.println("Nova Pessoa adicionada");
		totPessoas++;
		showsPerCent(pessoa);
	}
	
	public static void mostraLista() {
		List<String> aux = new ArrayList<String>();
		for(Pessoa item : listaPessoas) {
			aux.add(item.getNome());
		}
		Collections.sort(aux);
		
		for(String name : aux) {
			for(Pessoa item : listaPessoas) {
				if(item.getNome() == name){
					System.out.println(item.toString());
					break;
				}
			}
		}
	}
	
	public static void showsPerCent(Pessoa pessoa) {
		double mesmaFaixa=0;
		for(Pessoa item : listaPessoas) {
			if(item.getIdade() > pessoa.getIdade()-3 && item.getIdade()<pessoa.getIdade()+3) {
				mesmaFaixa ++;
			}
		}
		System.out.println("Porcentagem de pessoas na mesma faixa etária da nova pessoa: "+ 100*(mesmaFaixa/totPessoas));
		
	}
	
}
