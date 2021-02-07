package apresentação;

import negocio.Sistema;
import java.util.Scanner;
import dados.Semestre;
import dados.Disciplina;
import dados.Avaliacao;

public class Main {
	
	private static Scanner s = new Scanner(System.in);
	private static Sistema sistema = new Sistema();
	
	
	public static void main(String[] args) {
		menu();

	}
	
	private static void imprimeMenuGeral() {
		System.out.println("Escolha uma operação");
		System.out.println("0 - Fechar");
		System.out.println("1 - Cadastrar Semestre");
		System.out.println("2 - Cadastrar Disciplina");
		System.out.println("3 - Cadastrar Avaliação");
		System.out.println("4 - Editar Semestre");
		System.out.println("5 - Excluir Semestre");
		System.out.println("6 - Excluir Disciplina");
		System.out.println("7 - Excluir Avaliação");
	}
	
	private static void imprimeMenuEdição() {
		System.out.println("Escolha uma operação");
		System.out.println("0 - Fechar");
		System.out.println("1 - Editar uma Disciplina");
		System.out.println("2 - Editar  uma Avaliação");
	}
	
	private static void menu() {
		int opcao = -1;
		while(opcao!=0) {
			imprimeMenuGeral();
			System.out.print("Informe a opção::::");
			opcao = Integer.parseInt(s.nextLine());
			switch(opcao) {
				case 0:
					break;
				case 1:
					Semestre a = novoSemestre();
					if(sistema.verificaPossibilidadeSemestre(a)) {
						sistema.cadastrarSemestre(a);;						
					}else {
						System.out.println("ERRO 003 - SEMESTRE JÁ EXISTE");
					}
					break;
				case 2:
	
					sistema.cadastrarDisciplina(identificandoSemestre(), novaDisciplina());
					break;
				case 3:
					Semestre b = identificandoSemestre();
					sistema.cadastrarAvaliacao(b, identificandoDisciplina(b), novaAvaliacao());;
					break;
				case 4:
					editarSemestre();
					break;
				case 5:
					excluirSemestre();
					break;
				default:
					System.out.println("Numero inválido");
			}
		}
	}
	
	private static Semestre novoSemestre() {
		Semestre aux = new Semestre();
		System.out.println("Informe a identificação do semestre");
		aux.setIdentificacao(s.nextLine());
		
		return aux;
	}
	
	private static Semestre identificandoSemestre() { 
		Semestre aux = new Semestre();
		sistema.mostraSemestres();
		System.out.println("Informe o identificador do semestre em que deseja cadastrar uma disciplina");
		aux.setIdentificacao(s.nextLine());
		
		return aux;
	}
	
	private static Disciplina novaDisciplina() {
		Disciplina aux = new Disciplina();
		System.out.println("Informe o nome da disciplina");
		aux.setNome(s.nextLine());
		System.out.println("Informe o código da disciplina");
		aux.setCodDisciplina(s.nextLine());
		System.out.println("Informe o nome do professor da disciplina");
		aux.setProfessor(s.nextLine());
		
		return aux;
	}
	
	private static Disciplina identificandoDisciplina(Semestre b) {
		Disciplina aux = new Disciplina();
		sistema.mostraDisciplinas(b);		
		System.out.println("Informe o código da disciplina que deseja cadastrar uma avaliacao");
		aux.setCodDisciplina(s.nextLine());
		return aux;
	}
	
	private static Avaliacao novaAvaliacao() {
		Avaliacao aux = new Avaliacao();
		System.out.println("Informe o nome da avaliacao");
		aux.setNome(s.nextLine());
		System.out.println("Informe a data da avaliacao");
		aux.setData(s.nextLine());
		System.out.println("Informe o peso da avaliacao");
		aux.setPeso(Float.parseFloat(s.nextLine()));
		System.out.println("Informe a nota da avaliacao");
		aux.setNota(Float.parseFloat(s.nextLine()));
		return aux;
	}
	
	private static void editarSemestre() {
		int choose = -1;
		while(choose != 0) {
			imprimeMenuEdição();
			System.out.print("Informe a opção::::");
			choose = Integer.parseInt(s.nextLine());
			switch (choose) {
				case 0:
					break;
				case 1:
					editarDisciplina();
					break;
				case 2:
					editarAvaliacao();
					break;
				default:
					System.out.println("Opção inválida");
			}
		}
	}
	
	private static void editarDisciplina() {
		sistema.mostraSemestres();
		System.out.println("Informe o identificador do semestre que contém a disciplina a ser editada");
		Semestre a = new Semestre();
		a.setIdentificacao(s.nextLine());
		sistema.mostraDisciplinas(a);
		System.out.println("Informe o código da disciplina que deseja editar");
		String info = s.nextLine();
		
		Disciplina d = new Disciplina();
		d.setCodDisciplina(info);
		//Caso queira por a opção de editar apenas um campo, necessário criar um método que
		//retorne a disciplina com o cod escolhido, e editar as informações neste objeto
		System.out.println("	Editando nome:");
		d.setNome(s.nextLine());
		System.out.println("	Editando professor");
		d.setProfessor(s.nextLine());
		sistema.editarDisciplina(a, d);
	}
	
	private static void editarAvaliacao() {
		sistema.mostraSemestres();
		System.out.println("Informe o identificador do semestre ");
		Semestre a = new Semestre();
		a = sistema.getSemestre(s.nextLine());
		if(a != null) {
			
			sistema.mostraDisciplinas(a);
			System.out.println("Informe o código da disciplina ");
			Disciplina d = new Disciplina();
			d = a.getDisciplina(s.nextLine());
			if(d!=null) {
				sistema.mostraAvaliacoes(d);
				
				System.out.println("Informe o nome da avaliação que deseja editar");
				Avaliacao av = new Avaliacao();
				av.setNome(s.nextLine());
				System.out.println("Informe a data da avaliacao");
				av.setData(s.nextLine());
				System.out.println("Informe o peso da avaliacao");
				av.setPeso(Float.parseFloat(s.nextLine()));
				System.out.println("Informe a nota da avaliacao");
				av.setNota(Float.parseFloat(s.nextLine()));
				
				
				sistema.editarAvaliacao(a, d, av);
			}else {
				System.out.println("Disciplina não retornada");
			}
		}else {
			System.out.println("Semestre não retornado");
		}
	}
	
	private static void excluirSemestre() {
		sistema.mostraSemestres();
		System.out.println("Informe identificador do semestre que deseja excluir");
		String in = s.nextLine();
		if(sistema.verificaPossibilidadeSemestre(in)) {			
			sistema.excluirSemestre(in);
		}else {
			System.out.println("Semestre não existe");
		}
	}
	
	
	
}
