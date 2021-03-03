package persistencia;

import java.sql.*;
import dados.Pessoa;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;
import excecoes.UpdateException;
import java.util.LinkedList;
import java.util.List;
import dados.Endereco;

public class PessoaDAO {
	private static PessoaDAO instance = null;
	private static EnderecoDAO enderecoDAO = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement selectAll;
	private PreparedStatement update;
	
	public static PessoaDAO getInstance() throws ClassNotFoundException, SQLException, SelectException{
		if(instance == null) {
			instance = new PessoaDAO();
		}
		return instance;
	}
	
	private PessoaDAO( ) throws ClassNotFoundException, SQLException, SelectException{
		//construtor
		Connection conexao = Conexao.getConexao();
		selectNewId = conexao.prepareStatement("select nextval('id_pessoa_seq')");
		insert = conexao.prepareStatement("insert into pessoa values (?,?,?,?)");
		delete = conexao.prepareStatement("delete from pessoa where id = ?");
		selectAll = conexao.prepareStatement("select * from pessoa ");
		update = conexao.prepareStatement("update pessoa set nome = ?, telefone = ? where id = ?");
		enderecoDAO=EnderecoDAO.getInstance();
	}
	
	private int selectNewId() throws SelectException{
		try {
			ResultSet rs = selectNewId.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1); //ordem da coluna do que quer retornar, começa em 1
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao buscar novo id da tabela pessoa");
		}
		return 0;
	}
	
	public void insert(Pessoa pessoa) throws InsertException, SelectException{
		try {
			pessoa.setId(selectNewId());
			insert.setInt(1, pessoa.getId());
			insert.setString(2, pessoa.getNome());
			insert.setInt(3, pessoa.getCpf());
			insert.setInt(4, pessoa.getTelefone());
			insert.executeUpdate();
			pessoa.getEndereco().setIdPessoa(pessoa.getId());
			enderecoDAO.insert(pessoa.getEndereco());
		}catch(SQLException e){
			throw new InsertException("Erro ao inserir pessoa");
		}
	}
	
	public void delete(Pessoa p) throws DeleteException{
		enderecoDAO.delete(p.getEndereco());
		try {
			delete.setInt(1, p.getId());
			delete.executeUpdate();
		}catch(SQLException e){
			throw new DeleteException("Erro ao deletar pessoa");
		}
	}
	
	public void update(Pessoa pessoa) throws UpdateException{
		try {
			//perguntar porque o indice mudou
			enderecoDAO.update(pessoa.getEndereco());
			update.setString(1, pessoa.getNome());
			update.setInt(2, pessoa.getCpf());
			update.setInt(3, pessoa.getTelefone());
			update.setInt(4, pessoa.getId());
			update.executeUpdate();
		}catch(SQLException e){
			throw new UpdateException("Erro ao atualizar pessoa");
		}
	}
	
	public List<Pessoa> selectAll() throws SelectException{
		List<Pessoa> pessoas = new LinkedList<Pessoa>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				int cpf = rs.getInt(3);
				int telefone = rs.getInt(4);
				
				Endereco endereco = enderecoDAO.select(rs.getInt(1));
				pessoas.add(new Pessoa(id, nome, cpf, telefone, endereco));
			}
		}catch(SQLException e) {
			throw new SelectException("Eroo ao buscar pessoa");
		}
		return pessoas;
	}
	
}
