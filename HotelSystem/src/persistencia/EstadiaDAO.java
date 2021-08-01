package persistencia;

import java.sql.*;
import dados.*;
import java.util.List;
import java.util.ArrayList;

public class EstadiaDAO {
	private static EstadiaDAO instance = null;	

	private PreparedStatement insert;
	private PreparedStatement selectNewId;
	public static EstadiaDAO getInstance() {
		if(instance == null) {
			instance = new EstadiaDAO();
		}
		return instance;
	}
	
	private EstadiaDAO() {
		Connection conexao = Conexao.getConexao();

		try {
			selectNewId = conexao.prepareStatement("select nextval('seq_codestadia')");
			insert = conexao.prepareStatement("insert into estadia values(?,?,?,?)");
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
	
	public void insert(Estadia estadia) {
		estadia.setCodestadia(selectNewId());
		estadia.setValorextra(0.0);
		try {
			insert.setInt(1, estadia.getCodestadia());
			insert.setString(2, estadia.getCheckin());
			insert.setString(3, estadia.getCheckout());
			insert.setDouble(4, estadia.getValorextra());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
