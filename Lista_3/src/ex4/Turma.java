package ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Turma {
	private static List<Aluno> listaAlunos = new ArrayList<Aluno>();
	private static Scanner leitor = new Scanner(System.in);
	
	private static void ordenarAlunosPorIdade() {
		Collections.sort(listaAlunos);
	}
	
	public static void adicionarAluno(Aluno aluno) {
		listaAlunos.add(aluno);
	}
	
	public static void infoAluno() {
		Aluno aux =new Aluno();
		System.out.println("Informe o nome do aluno:");
		aux.setNome(leitor.nextLine());
		System.out.println("Informe a idade do aluno:");
		aux.setIdade(Integer.parseInt(leitor.nextLine()));
		adicionarAluno(aux);
	}
	
	public static void main(String []args) {
		int cont =0;
		while(true) {
			System.out.println("Deseja informar um aluno?(-1 para sair)");
			int flag = Integer.parseInt(leitor.nextLine());
			if(flag == -1) {
				break;
			}
			infoAluno();
			ordenarAlunosPorIdade();
			cont++;
			if(cont > 1) {
				System.out.println("Deseja verificar a lista de pares? (1 aceitar):");
				int choose = Integer.parseInt(leitor.nextLine());
				if(choose == 1) {
					List<Par<Aluno>> listaAux = separaEmPares();
					printListaPares(listaAux);
				}
			}
		}
	}
	
	public static List<Par<Aluno>> separaEmPares() {
		List<Par<Aluno>> listaPares = new ArrayList<Par<Aluno>>();
		//Não consegui implementar este método da forma correta, deixei aqui uma das tentativas
		int tamListaPares = (listaAlunos.size()/2) +1;
		for(int i=0; i<tamListaPares; i++) {
			Par<Aluno> par = new Par();
			listaPares.add(par);
		}
		System.out.println(listaPares.size());
		System.out.println(tamListaPares);
		
		for(Par<Aluno> aux : listaPares) {
			for(Aluno item : listaAlunos) {
				if(aux.getElemento1()==null) {
					aux.setElemento1(item);
				}else if(aux.getElemento2()==null){
					aux.setElemento2(item);
				}else {
					break;
				}
			}
		}
		
		return listaPares;
	}
	
	public static void printListaPares(List<Par<Aluno>> listaPares) {
	
		for(Par<Aluno> item : listaPares) {
			System.out.println(item.toString());
		}
	}
	
}
