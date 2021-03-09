package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao = null;
	private Conexao() {
		
	}
	public static Connection getConexao(){
		if(conexao == null) {
			String url = "jdbc:postgresql://localhost:5432/appNotas";
			String usuario = "postgres";
			String senha = "17012001";
			
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, usuario, senha);
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return conexao;
	}
}
