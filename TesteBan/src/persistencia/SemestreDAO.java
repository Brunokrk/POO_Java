package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Semestre;
import excecoes.InsertException;
import excecoes.SelectException;


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
	
	private SemestreDAO( )throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao = Conexao.getConexao();
		selectNewId = conexao.prepareStatement("select nextval('id_semestre_seq')");
		insert = conexao.prepareStatement("insert into semestre values(?, ?)");
	
	}
	
	private int selectNewId()throws SelectException {
		try {
			ResultSet rs = selectNewId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			throw new SelectException("Não foi possivel buscar novo id");
		}
		return 0;
	}
	
	public void insert(Semestre semestre)throws InsertException, SelectException {
		try {
			semestre.setId(selectNewId());
			insert.setInt(1,semestre.getId());
			insert.setString(2, semestre.getIdentificacao());
			System.out.println("Inseriu semestre");
		}catch(SQLException e) {
			throw new InsertException("Erro ao inserir semestre");
		}
	}
}
