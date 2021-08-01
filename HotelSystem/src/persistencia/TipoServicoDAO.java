package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Quarto;
import dados.tipoServico;

public class TipoServicoDAO {
	private static TipoServicoDAO instance = null;	


	
	private PreparedStatement selectAll;
	
	public static TipoServicoDAO getInstance() {
		if(instance == null) {
			instance = new TipoServicoDAO();
		}
		return instance;
	}
	
	private TipoServicoDAO() {
		Connection conexao = Conexao.getConexao();

		try {
			selectAll = conexao.prepareStatement("select * from tiposervico");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<tipoServico> selectAll(){
		List<tipoServico> servicos = new ArrayList<tipoServico>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int codtipo = rs.getInt(1);
				String tipo = rs.getString(2);
				Double preco = rs.getDouble(3);
				servicos.add(new tipoServico(codtipo, tipo, preco));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return servicos;
	}
	
	
}
