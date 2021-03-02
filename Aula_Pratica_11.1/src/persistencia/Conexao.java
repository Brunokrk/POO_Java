package persistencia;

import java.sql.*;

public class Conexao {

	private static Connection conexao = null;
	private static String senha;
	
	private Conexao() {
		
	}
	
	public static void setSenha(String password) {
		senha = password;
	}
	
	public static Connection getConexao() throws ClassNotFoundException, SQLException{
		if(conexao == null) {
			String url = "jdbc:postgresql://localhost:5432/pratica11";
			String usuario = "postgres";
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
		}
		return conexao;
	}
}
