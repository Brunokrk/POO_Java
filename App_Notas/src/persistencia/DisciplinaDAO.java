package persistencia;

import java.sql.*;
import dados.Disciplina;

public class DisciplinaDAO {
	private static DisciplinaDAO instance = null;
	private static AvaliacaoDAO avaliacaoDAO = null;
	
	private PreparedStatement selectNewId;
	//private PreparedStatement select;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	
	public static DisciplinaDAO getInstance() {
		if(instance == null) {
			instance = new DisciplinaDAO();
		}
		return instance;
	}
	
	private DisciplinaDAO() {
		//Construtor
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('id_disciplina_seq')");
			insert = conexao.prepareStatement("insert int disciplina values(?, ?, ?, ?, ?, ?, ?, ?)");
			delete = conexao.prepareStatement("delete from disciplina where id_disciplina = ?");
			update = conexao.prepareStatement("update disciplina set ");///continuar
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int selectNewId() {
		try {
			ResultSet rs = selectNewId.executeQuery();
			if(rs.next()) {
				return rs.getInt(2);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//idSemestre, isDisciplina, nome, codDisciplina, media, professor, nota_aprovação, situacao
	public void insert(Disciplina disciplina) {
		try {
			disciplina.setId(selectNewId());
			insert.setInt(1, disciplina.getIdSemestre());
			insert.setInt(2, disciplina.getId());
			insert.setString(3, disciplina.getNome());
			insert.setString(4, disciplina.getCodDisciplina());
			insert.setFloat(5, disciplina.getMedia());
			insert.setString(6, disciplina.getProfessor());
			insert.setDouble(7, disciplina.getNota_aprovacao());
			insert.setBoolean(8, disciplina.isSituacao());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Disciplina disciplina) {
		avaliacaoDAO.deleteAll(disciplina.getId());
		try {
			delete.setInt(1, disciplina.getId());
			delete.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Disciplina disciplina) {
		try {
			//continuar
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
