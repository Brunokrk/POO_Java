package negocio;

import java.sql.SQLException;
import java.util.List;

import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;
import excecoes.UpdateException;
import persistencia.Conexao;
import persistencia.PessoaDAO;
import dados.Pessoa;

public class Sistema {
	private PessoaDAO pessoaDAO;
	
	public Sistema(String senha) throws ClassNotFoundException, SQLException, SelectException{
		Conexao.setSenha(senha);
		pessoaDAO = PessoaDAO.getInstance();
	}
	
	public void inserirPessoa(Pessoa p)throws InsertException, SelectException{
		pessoaDAO.insert(p);
	}
	
	public List<Pessoa> selectAll() throws SelectException {
		return pessoaDAO.selectAll();
	}
	
	public void deletePessoa(Pessoa p) throws DeleteException{
		pessoaDAO.delete(p);
	}
	
	public void atualizarPessoa(Pessoa p) throws UpdateException{
		pessoaDAO.update(p);
	}
}
