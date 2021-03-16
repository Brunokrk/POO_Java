package apre;

import java.sql.SQLException;

import dados.Semestre;
import excecoes.InsertException;
import excecoes.SelectException;
import persistencia.Conexao;
import persistencia.SemestreDAO;

public class Main {

	public static void main(String[] args) {
		Conexao.setSenha("17012001");
		Semestre s1 = new Semestre();
		s1.setIdentificacao("2021-1");
		
		try {
			SemestreDAO semestreDAO = SemestreDAO.getInstance();
			try {
				semestreDAO.insert(s1);
				
			}catch(InsertException e) {
				e.printStackTrace();
			}
		}catch(ClassNotFoundException | SQLException | SelectException e) {
			e.printStackTrace();
		}
	}

}
