package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Extra;

public class ExtraDAO {
	private static ExtraDAO instance = null;
	
	private PreparedStatement insert;
	private PreparedStatement selectNewId;
	private PreparedStatement calculaExtra;
	
	public static ExtraDAO getInstance() {
		if(instance == null) {
			instance = new ExtraDAO();
		}
		return instance;
	}
	
	private ExtraDAO() {
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('seq_codextra')");
			insert = conexao.prepareStatement("insert into extra values(?,?,?,?,?)");
			calculaExtra = conexao.prepareStatement("select calculaextra(?) ");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void calculaExtra(int cod) {
		try {
			calculaExtra.setInt(1, cod);
			calculaExtra.executeQuery();
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
	
	public void insert(Extra extra) {
		extra.setCodExtra(selectNewId());
		try {
			insert.setInt(1, extra.getCodExtra());
			insert.setInt(2, extra.getCodTipo());
			insert.setInt(3, extra.getCodEstadia());
			insert.setString(4, extra.getDia());
			insert.setString(5, extra.getHora());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
