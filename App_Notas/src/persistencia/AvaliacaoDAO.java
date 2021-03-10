package persistencia;

import java.sql.*;
import dados.Avaliacao;


public class AvaliacaoDAO {
	private static AvaliacaoDAO instance = null;
	private PreparedStatement selectNewId;
	private PreparedStatement select;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement deleteAll;//deleta todas as avaliações de uma Disciplina X
	
	public static AvaliacaoDAO getInstance() {
		if(instance == null) {
			instance = new AvaliacaoDAO();
		}
		return instance;
	}
	
	private AvaliacaoDAO() {
		//Construtor
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('id_avaliacao_seq')");
			insert = conexao.prepareStatement("insert into avaliacao values (?,?,?,?,?,?)");
			select = conexao.prepareStatement("select * from avaliacao where id_avaliacao = ?");
			update = conexao.prepareStatement("update endereco set id_disciplina = ?, nome = ?, nota = ?, peso = ?, dia = ?, where id_avaliacao = ? ");
			delete = conexao.prepareStatement("delete from avaliacao where id_avaliacao = ?");
			deleteAll = conexao.prepareStatement("delete from avaliacao where id_disciplina = ?");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int selectNewId() {
		try {
			ResultSet rs = selectNewId.executeQuery();
			if (rs.next()){
				return rs.getInt(2);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void insert(Avaliacao av) {
		try {
			insert.setInt(1, av.getIdDisciplina());
			insert.setInt(2, selectNewId());
			insert.setString(3, av.getNome());
			insert.setFloat(4, av.getNota());//mudar nota para float no banco de dados
			insert.setFloat(5, av.getPeso());
			insert.setString(6, av.getData());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Avaliacao select(int id) {
		try {
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				int id_Dis = rs.getInt(1);
				int id_Av = rs.getInt(2);
				String nome = rs.getString(3);
				Float nota = rs.getFloat(4);
				Float peso = rs.getFloat(5);
				String data = rs.getString(6);
				return new Avaliacao(id_Dis, id_Av, nome, nota, peso, data);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(Avaliacao avaliacao) {
		try {
			update.setInt(1, avaliacao.getId());
			update.setString(2,  avaliacao.getNome());
			update.setFloat(3, avaliacao.getNota());
			update.setFloat(4, avaliacao.getPeso());
			update.setString(5, avaliacao.getData());
			update.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Avaliacao avaliacao) {
		try {
			delete.setInt(1, avaliacao.getId());
			delete.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAll(int id_disciplina) {
		try {
			delete.setInt(1, id_disciplina);
			delete.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}








