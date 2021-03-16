package persistencia;

import java.sql.*;
import dados.*;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;
import excecoes.UpdateException;
//import java.util.LinkedList;
//import java.util.List;



public class SemestreDAO {
	
	private static SemestreDAO instance = null;
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	
	public static SemestreDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
		if(instance == null) {
			instance =  new SemestreDAO();
		}
		return instance;
	}
	
	private SemestreDAO( ) throws ClassNotFoundException, SQLException, SelectException{
		Connection conexao = Conexao.getConexao();
		selectNewId = conexao.prepareStatement("select nextval('id_semestre')");
		insert = conexao.prepareStatement("insert into semestre (id, identificacao) values (?, ?)");
	}
	
	private int selectNewId() throws SelectException {
		try {
			ResultSet rs = selectNewId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao buscar novo id da tabela semestre");
		}
		return 0;
	}
	
	public void insert(Semestre semestre) throws InsertException, SelectException {
		semestre.setId(selectNewId());
		System.out.println(""+semestre.getIdentificacao()+" "+semestre.getId());
		try {
			insert.setInt(1,semestre.getId());
			insert.setString(2, semestre.getIdentificacao());
			//System.out.println("Inseriu semestre");
		}catch(SQLException e) {
			throw new InsertException("Erro ao inserir semestre");
		}
	}
}
