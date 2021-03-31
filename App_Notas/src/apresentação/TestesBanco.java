package apresentação;

import negocio.Sistema;
import dados.Semestre;
import dados.Disciplina;
import java.sql.SQLException;
import java.util.List;

import dados.Avaliacao;
import persistencia.*;
import excecoes.*;


public class TestesBanco {
	//private static Sistema sistema = Sistema.getInstance();

	public static void main(String[] args) {
		
		//SemestreDAO semestreDAO = SemestreDAO.getInstance();
		//DisciplinaDAO disciplinaDAO = DisciplinaDAO.getInstance();
		
		//Semestre s1 = new Semestre();
		//s1.setIdentificacao("TESTE-TESTE");
		//sistema.cadastrarSemestre(s1);
		
		//Semestre s2 = new Semestre();
		//s2.setIdentificacao("2021-2");
		
		//Semestre s3 = new Semestre();
		//s3.setIdentificacao("2022-1");
		
		//Semestre s4 = new Semestre();
		//s4.setIdentificacao("2022-3");
		
		//Disciplina d1 = new Disciplina();
		//d1.setIdSemestre(3);
		//d1.setCodDisciplina("POO001");
		//d1.setNome("Programação Orientada a Objetos");		
		//d1.setProfessor("Fabiano Baldo");
		//d1.setNota_aprovacao(0.0);
		//d1.setMedia(0.0);
		
		//Disciplina d1 = new Disciplina();
		//d1.setIdSemestre(12);
		//d1.setCodDisciplina("M4");
		//d1.setNome("materia 4");		
		//d1.setProfessor("Fabiano Baldo");
		//d1.setNota_aprovacao(0.0);
		//d1.setMedia(0.0);
		
		//Testes com sistema
		//sistema.cadastrarSemestre(s1);
		//sistema.cadastrarSemestre(s2);
		//sistema.cadastrarSemestre(s3);
		//sistema.cadastrarSemestre(s4);
		//sistema.excluirSemestre("2022-1");
		//sistema.mostraSemestres();
		
		//sistema.cadastrarDisciplina(s1, d1);
		//sistema.excluirDisciplina("2021-1", "POO001");
		
		//edita a disciplina com id 5, transformando na d1
		//sistema.editarDisciplina(disciplinaDAO.select(5),semestreDAO.select(12), d1);
		
		
		//Avaliacao av1 = new Avaliacao("P1", 7.5, 0.50, "17-01-01");
		//Avaliacao av2 = new Avaliacao("P2", 7.0, 0.50, "18-01-01");
		//sistema.cadastrarAvaliacao(semestreDAO.select(12), disciplinaDAO.select(5), av1);
		//sistema.cadastrarAvaliacao(semestreDAO.select(12), disciplinaDAO.select(5), av2);
		//sistema.excluirAvaliacao("2021-1", "M4", "P1");
		
		//sistema.mostraSemestres();
		
		
		
		//testes sem o sistema
		//Disciplina d1 = new Disciplina();
		//d1.setIdSemestre(3);
		//d1.setCodDisciplina("POO001");
		//d1.setNome("Programação Orientada a Objetos");		
		//d1.setProfessor("Fabiano Baldo");
		//d1.setNota_aprovacao(0.0);
		//d1.setMedia(0.0);
		
		//semestreDAO.insert(s1);
		//semestreDAO.insert(s2);
		//semestreDAO.insert(s3);
		//semestreDAO.insert(s4);
		//sistema.mostraSemestres();
				
		//Semestre aux = semestreDAO.select(3);
		//System.out.println(aux.getId()+" "+aux.getIdentificacao());
				
		//Semestre aux = semestreDAO.select(4); //implementar um deleteById se necessario
		//semestreDAO.delete(aux);
		//semestreDAO.deleteAll();
				
		//Semestre aux = semestreDAO.select(3);
		//aux.setIdentificacao("2023-1");
		//semestreDAO.update(aux);
		
		//Semestre aux = semestreDAO.select(3);
		//semestreDAO.delete(aux);
		
		//-----------
				
		//disciplinaDAO.insert(d1);
		
			
		
			
		//Disciplina d1 = new Disciplina();
		//d1.setCodDisciplina("POO001");
		//d1.setNome("Programação Orientada a Objetos");
		//d1.setProfessor("Fabiano Baldo");
		//d1.setMedia(7.50);
		//d1.setIdSemestre(3);
		//d1.setNota_aprovacao(0.0);
		//sis.cadastrarDisciplina(s1, d1);
		//disciplinaDAO.insert(d1);
		
		//Avaliacao av1 = new Avaliacao();
		//av1.setNome("Prova 1");
		//av1.setNota(7.50);
		//av1.setPeso(0.50);
		//sis.cadastrarAvaliacao(s1, d1, av1);
		//AvaliacaoDAO avaliacaoDAO = AvaliacaoDAO.getInstance();
		//avaliacaoDAO.insert(av1);
		
		//Avaliacao av2 = new Avaliacao();
		//av2.setNome("Prova 1");
		//av2.setNota(Float.parseFloat("7.50"));
		//av2.setPeso(Float.parseFloat("0.50"));
		//sis.cadastrarAvaliacao(s1, d1, av2);
		//avaliacaoDAO.insert(av2);

		
	}

}
