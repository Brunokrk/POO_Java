package persistencia;

import java.sql.*;
import dados.*;
import java.util.List;
import java.util.ArrayList;

public class EmpregadoDAO {

	private static EmpregadoDAO instance = null;
	private PreparedStatement selectAll;
	
	
	public static EmpregadoDAO getInstance() {
		if(instance == null) {
			instance = new EmpregadoDAO();
		}
		return instance;
	}
	
	private EmpregadoDAO() {
		Connection conexao = Conexao.getConexao();

		try {
			selectAll = conexao.prepareStatement("select * from empregado");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<Empregado> selectAll(){
		List<Empregado> empregados = new ArrayList<Empregado>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int nRegistro = rs.getInt(1);
				String nome = rs.getString(2);
				empregados.add(new Empregado(nRegistro, nome ));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empregados;
	}
	
	
}
