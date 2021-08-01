package persistencia;

import java.sql.*;
import dados.*;
import java.util.List;
import java.util.ArrayList;

public class QuartoDAO {

	private static QuartoDAO instance = null;

	private PreparedStatement selectAllQuarto;
	private PreparedStatement selectAllSingle;
	private PreparedStatement selectAllDuplo;
	private PreparedStatement selectAllSuite;
	private PreparedStatement selectAllCasal;

	public static QuartoDAO getInstance() {
		if(instance == null) {
			instance = new QuartoDAO();
		}
		return instance;
	}
	
	private QuartoDAO() {
		Connection conexao = Conexao.getConexao();

		try {
			selectAllQuarto = conexao.prepareStatement("select * from quarto");
			selectAllSingle = conexao.prepareStatement("select * from single");
			selectAllDuplo = conexao.prepareStatement("select * from duplo");
			selectAllSuite = conexao.prepareStatement("select * from suite");
			selectAllCasal = conexao.prepareStatement("select * from casal");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Quarto> selectAllQuarto(){
		List<Quarto> quartos = new ArrayList<Quarto>();
		
		try {
			ResultSet rs = selectAllQuarto.executeQuery();
			while(rs.next()) {
				int codHotel = rs.getInt(1);
				int nroa = rs.getInt(2);
				int andar = rs.getInt(3);
				quartos.add(new Quarto(codHotel, nroa, andar));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return quartos;
	}
	
	public List<Quarto> selectAllSingle(){
		List<Quarto> quartos = new ArrayList<Quarto>();
		
		try {
			ResultSet rs = selectAllSingle.executeQuery();
			while(rs.next()) {
				int nroa = rs.getInt(1);
				int andar = rs.getInt(2);
				int codHotel = rs.getInt(4);
				quartos.add(new Single(codHotel, nroa, andar));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return quartos;
	}
	
	public List<Quarto> selectAllCasal(){
		List<Quarto> quartos = new ArrayList<Quarto>();
		
		try {
			ResultSet rs = selectAllCasal.executeQuery();
			while(rs.next()) {
				int nroa = rs.getInt(1);
				int andar = rs.getInt(2);
				int ncamas = rs.getInt(3);
				int codHotel = rs.getInt(5);
				quartos.add(new Casal(codHotel, nroa, andar, ncamas));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return quartos;
	}
	
	public List<Quarto> selectAllDuplo(){
		List<Quarto> quartos = new ArrayList<Quarto>();
		
		try {
			ResultSet rs = selectAllDuplo.executeQuery();
			while(rs.next()) {
				int nroa = rs.getInt(1);
				int andar = rs.getInt(2);
				int ncamas = rs.getInt(3);
				int codHotel = rs.getInt(5);
				quartos.add(new Duplo(codHotel, nroa, andar, ncamas));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return quartos;
	}
	
	public List<Quarto> selectAllSuite(){
		List<Quarto> quartos = new ArrayList<Quarto>();
		
		try {
			ResultSet rs = selectAllSuite.executeQuery();
			while(rs.next()) {
				int nroa = rs.getInt(1);
				int andar = rs.getInt(2);
				int ncamas = rs.getInt(3);
				int codHotel = rs.getInt(5);
				quartos.add(new Suite(codHotel, nroa, andar, ncamas));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return quartos;
	}
	
	
	
	
	
	
	
	
	
	
}
