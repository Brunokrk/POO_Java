package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Limpeza;

public class LimpezaDAO {
	
	private static LimpezaDAO instance = null;
	
	private PreparedStatement insert;
	private PreparedStatement selectNewId;
	
	public static LimpezaDAO getInstance() {
		if(instance == null) {
			instance = new LimpezaDAO();
		}
		return instance;
	}
	
	private LimpezaDAO() {
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('seq_codlimpeza')");
			insert = conexao.prepareStatement("insert into limpeza values(?,?,?,?)");
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
	
	public void insert(Limpeza limpeza) {
		limpeza.setCodLimpeza(selectNewId());;
		try {
			insert.setInt(1, limpeza.getCodLimpeza());
			insert.setString(2, limpeza.getTempo());
			insert.setInt(3, limpeza.getCodReseva());
			insert.setInt(4, limpeza.getnRegEmp());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
