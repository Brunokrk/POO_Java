package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dados.*;

public class ReservaDAO {

	private static ReservaDAO instance = null;
	
	private PreparedStatement selectAll;
	private PreparedStatement insert;
	private PreparedStatement selectNewId;
	
	public static ReservaDAO getInstance() {
		if(instance == null) {
			instance = new ReservaDAO();
		}
		return instance;
	}
	
	private ReservaDAO() {
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('seq_codreserva')");
			selectAll = conexao.prepareStatement("select * from reserva");
			insert = conexao.prepareStatement("insert into reserva values (?,?,?,?,?,?)");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Reserva reserva) {
		
		reserva.setCodreserva(selectNewId());
		try {
			insert.setInt(1, reserva.getCodreserva());
			insert.setInt(2, reserva.getNroa());
			insert.setInt(3, reserva.getCodestadia());
			insert.setString(4, reserva.getDiaentrada());
			insert.setString(5, reserva.getDiareserva());
			insert.setInt(6, reserva.getCodcliente());
			insert.executeUpdate();
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
	
	public List<Reserva> selectAll(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int codReserva = rs.getInt(1);
				int nroa = rs.getInt(2);
				int codEstadia = rs.getInt(3);
				String diaEntrada = rs.getString(4);
				String diaReserva = rs.getString(5);
				int codCliente = rs.getInt(6);
				reservas.add(new Reserva(codReserva, nroa,codEstadia, diaEntrada, diaReserva, codCliente));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reservas;
	}
}








