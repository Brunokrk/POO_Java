package persistencia;

import java.sql.*;

public class Conexao {

	private static Connection conexao = null;
	
	
	private Conexao() {
		
	}
	
	
	public static Connection getConexao() {
		if(conexao == null) {
			String url = "jdbc:postgresql://localhost:5432/bancoapp";
			String usuario = "postgres";
			String senha = "17012001";
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Conexao estabelecida.");
				
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		return conexao;
	}
}

