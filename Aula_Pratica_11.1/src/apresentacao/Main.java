package apresentacao;

import negocio.Sistema;
import persistencia.Conexao;
import persistencia.PessoaDAO;
import dados.Pessoa;
import dados.Endereco;
import java.sql.SQLException;

import excecoes.*;

public class Main {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("IAIAIA");
		p.setCpf(1231341);
		p.setTelefone(1231231);
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Andrei");
		p1.setCpf(1231341);
		p1.setTelefone(1231231);
		
		Endereco end =  new Endereco();
		end.setCidade("Tubarao");
		end.setNumero(221);
		end.setRua("Teodoto tonon");
		
		p.setEndereco(end);
		p1.setEndereco(end);
		
		Conexao.setSenha("17012001");
		
		try {
			PessoaDAO pessoaDAO = PessoaDAO.getInstance();
			try {
				pessoaDAO.insert(p);
				pessoaDAO.insert(p1);
				
			}catch(InsertException e) {
				e.printStackTrace();
			}
		}catch(ClassNotFoundException | SQLException | SelectException e) {
			e.printStackTrace();
		}
	}

}
