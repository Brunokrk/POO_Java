package persistencia;

import java.sql.*;
import dados.*;
import java.util.List;
import java.util.ArrayList;

public class EstadiaDAO {
	private static EstadiaDAO instance = null;	

	private PreparedStatement insert;
	private PreparedStatement selectNewId;
	private PreparedStatement selectAll;
	
	
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
			insert = conexao.prepareStatement("insert into estadia values(?,?,?,?,?,?)");
			selectAll = conexao.prepareStatement("select * from estadia");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Estadia> selectAll(){
		List<Estadia> estadias = new ArrayList<Estadia>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int codEstadia = rs.getInt(1);
				String checkin = rs.getString(2);
				String checkout = rs.getString(3);
				Double valorExtra = rs.getDouble(4);
				int codcliente = rs.getInt(5);
				int nroa = rs.getInt(6);
				estadias.add(new Estadia(codEstadia, checkin, checkout, valorExtra, codcliente, nroa));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return estadias;
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
			insert.setInt(5,  estadia.getCodcliente());
			insert.setInt(6, estadia.getNroa());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
