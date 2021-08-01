package persistencia;

import java.sql.*;
import dados.*;


public class ClienteDAO {
	
	private static ClienteDAO instance = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement deleteAll;
	private PreparedStatement select;
	
	public static ClienteDAO getInstance() {
		if(instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}
	
	private ClienteDAO() {
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('seq_nregistro_cli')");
			insert = conexao.prepareStatement("insert into cliente values(?,?,?,?,?,?,?)");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int selectNewId() {
		try {
			ResultSet rs = selectNewId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void insert(Cliente cliente) {
		cliente.setnRegistro(selectNewId());
		try {
			insert.setInt(1, cliente.getnRegistro());
			insert.setString(2, cliente.getCidade());
			insert.setString(3, cliente.getEstado());
			insert.setString(4, cliente.getRua());
			insert.setString(5, cliente.getBairro());
			insert.setInt(6, cliente.getTelefone());
			insert.setString(7, cliente.getNome());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
