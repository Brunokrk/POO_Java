package apresenta��o;

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
		System.out.println("Escolha uma opera��o");
		System.out.println("0 - Fechar");
		System.out.println("1 - Cadastrar Semestre");
		System.out.println("2 - Cadastrar Disciplina");
		System.out.println("3 - Cadastrar Avalia��o");
		System.out.println("4 - Editar Semestre");
		System.out.println("5 - Excluir Semestre");
		System.out.println("6 - Excluir Disciplina");
		System.out.println("7 - Excluir Avalia��o");
		System.out.println("8 - Gerar PDF");
	}
	
	private static void imprimeMenuEdi��o() {
		System.out.println("Escolha uma opera��o");
		System.out.println("0 - Fechar");
		System.out.println("1 - Editar uma Disciplina");
		System.out.println("2 - Editar  uma Avalia��o");
	}
	
	private static void menu() {
		int opcao = -1;
		while(opcao!=0) {
			imprimeMenuGeral();
			System.out.print("Informe a op��o::::");
			opcao = Integer.parseInt(s.nextLine());
			switch(opcao) {
				case 0:
					break;
				case 1:
					Semestre a = novoSemestre();
					if(sistema.verificaPossibilidadeAddSemestre(a)) {
						sistema.cadastrarSemestre(a);;						
					}else {
						System.out.println("ERRO 003 - SEMESTRE J� EXISTE");
					}
					break;
				case 2:
					Semestre c = identificandoSemestre();
					if(sistema.verificaPossibilidadeExclSemestre(c.getIdentificacao())) {
						sistema.cadastrarDisciplina(c, novaDisciplina());						
					}else {
						System.out.println("ERRO 004 - SEMESTRE INEXISTENTE");
					}
					break;
				case 3:
					Semestre b = identificandoSemestre();
					if(sistema.verificaPossibilidadeExclSemestre(b.getIdentificacao())) {
						Disciplina d = identificandoDisciplina(b);
						if(sistema.verificaPossibilidadeExclDisciplina(b.getIdentificacao(), d.getCodDisciplina())) {
							sistema.cadastrarAvaliacao(b, d, novaAvaliacao());;													
						}else {
							System.out.println("ERRO 005 - DISCIPLINA INEXISTENTE");
						}
					}else {
						System.out.println("EROO 004 - SEMESTRE INEXISTENTE");
					}
					break;
				case 4:
					editarSemestre();
					break;
				case 5:
					excluirSemestre();
					break;
				case 6:
					excluirDisciplina();
					break;
				case 7:
					excluirAvaliacao();
					break;
				case 8:
					gerarPDF();
					break;
				default:
					System.out.println("Numero inv�lido");
			}
		}
	}
	
	private static Semestre novoSemestre() {
		Semestre aux = new Semestre();
		System.out.println("Informe a identifica��o do semestre");
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
		System.out.println("Informe o c�digo da disciplina");
		aux.setCodDisciplina(s.nextLine());
		System.out.println("Informe o nome do professor da disciplina");
		aux.setProfessor(s.nextLine());
		
		return aux;
	}
	
	private static Disciplina identificandoDisciplina(Semestre b) {
		Disciplina aux = new Disciplina();
		sistema.mostraDisciplinas(b);		
		System.out.println("Informe o c�digo da disciplina que deseja cadastrar uma avaliacao");
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
			imprimeMenuEdi��o();
			System.out.print("Informe a op��o::::");
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
					System.out.println("Op��o inv�lida");
			}
		}
	}
	
	private static void editarDisciplina() {
		sistema.mostraSemestres();
		System.out.println("Informe o identificador do semestre que cont�m a disciplina a ser editada");
		Semestre a = new Semestre();
		a.setIdentificacao(s.nextLine());
		sistema.mostraDisciplinas(a);
		System.out.println("Informe o c�digo da disciplina que deseja editar");
		String info = s.nextLine();
		
		Disciplina d = new Disciplina();
		d.setCodDisciplina(info);
		//Caso queira por a op��o de editar apenas um campo, necess�rio criar um m�todo que
		//retorne a disciplina com o cod escolhido, e editar as informa��es neste objeto
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
			System.out.println("Informe o c�digo da disciplina ");
			Disciplina d = new Disciplina();
			d = a.getDisciplina(s.nextLine());
			if(d!=null) {
				sistema.mostraAvaliacoes(d);
				
				System.out.println("Informe o nome da avalia��o que deseja editar");
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
				System.out.println("Disciplina n�o retornada");
			}
		}else {
			System.out.println("Semestre n�o retornado");
		}
	}
	
	private static void excluirSemestre() {
		sistema.mostraSemestres();
		System.out.println("Informe identificador do semestre que deseja excluir");
		String in = s.nextLine();
		if(sistema.verificaPossibilidadeExclSemestre(in)) {			
			sistema.excluirSemestre(in);
		}else {
			System.out.println("Semestre n�o existe");
		}
	}
	
	private static void excluirDisciplina() {
		sistema.mostraSemestres();
		System.out.println("Informe identificador do semestre ");
		String in = s.nextLine();
		if(sistema.verificaPossibilidadeExclSemestre(in)) {
			//semestre existe
			sistema.mostraDisciplinas(in);
			System.out.println("Informe o c�digo da disciplina que deseja excluir");
			String inDisc = s.nextLine();
			if(sistema.verificaPossibilidadeExclDisciplina(in, inDisc)) {
				sistema.excluirDisciplina(in, inDisc);
			}
		}else {
			System.out.println("Semestre n�o existe");
		}
	}
	
	private static void excluirAvaliacao() {
		sistema.mostraSemestres();
		System.out.println("Informe identificador do semestre ");
		String in = s.nextLine();
		if(sistema.verificaPossibilidadeExclSemestre(in)) {
			sistema.mostraDisciplinas(in);
			System.out.println("Informe o c�digo da disciplina ");
			String inDisc = s.nextLine();
			if(sistema.verificaPossibilidadeExclDisciplina(in, inDisc)) {
				//disciplina existe
				sistema.mostraAvaliacoes(in, inDisc);
				System.out.println("Informe o nome da avaliacao que deseja excluir");
				String av = s.nextLine();
				sistema.excluirAvaliacao(in, inDisc, av);
			}
		}
	}
	
	private static void gerarPDF() {
		sistema.mostraSemestres();
		System.out.println("Informe o semestre que deseja emitir relat�rio");
		String id = s.nextLine();
		if(sistema.verificaPossibilidadeExclSemestre(id)) {
			sistema.gerarPDF(id);		
		}else {
			System.out.println("Semestre n�o existe, n�o � poss�vel gerar relat�rio");
		}
	}
	
}
