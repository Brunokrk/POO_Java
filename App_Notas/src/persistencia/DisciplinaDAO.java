package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dados.Avaliacao;
import dados.Disciplina;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;
import excecoes.UpdateException;

public class DisciplinaDAO {
	private static DisciplinaDAO instance = null;
	private static AvaliacaoDAO avaliacaoDAO = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement deleteAll;
	private PreparedStatement update;
	private PreparedStatement updateMedias;
	
	public static DisciplinaDAO getInstance() {
		if(instance == null) {
			instance = new DisciplinaDAO();
		}
		return instance;
	}
	
	private DisciplinaDAO(){
		//Construtor
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('id_disciplina')");
			insert = conexao.prepareStatement("insert into disciplina values(?, ?, ?, ?, ?, ?, ?, ?)");
			delete = conexao.prepareStatement("delete from disciplina where id= ?");
			deleteAll = conexao.prepareStatement("delete from disciplina where idSemestre = ?");
			select = conexao.prepareStatement("select * from disciplina where id = ?");
			selectAll = conexao.prepareStatement("select * from disciplina where idsemestre = ?");
			update = conexao.prepareStatement("update disciplina set nome = ?, codDisciplina = ?, media = ?, professor = ?, notaAprovacao = ?, situacao = ? where id= ?");
			updateMedias = conexao.prepareStatement("update disciplina set media = ?, notaaprovacao = ?, situacao = ? where id =?");
			avaliacaoDAO = AvaliacaoDAO.getInstance();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int selectNewId(){
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
	//idSemestre, isDisciplina, nome, codDisciplina, media, professor, nota_aprovação, situacao
	public void insert(Disciplina disciplina) {
		try {
			disciplina.setId(selectNewId());
			insert.setInt(1, disciplina.getId());
			insert.setInt(2, disciplina.getIdSemestre());
			insert.setString(3, disciplina.getNome());
			insert.setString(4, disciplina.getProfessor());
			insert.setDouble(5, disciplina.getMedia());
			insert.setDouble(6, disciplina.getNota_aprovacao());
			insert.setString(7, disciplina.getCodDisciplina());
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
	
	public void deleteAll(int id_s) {
		try {
			deleteAll.setInt(1, id_s);
			deleteAll.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Disciplina disciplina){
		//idSemestre, isDisciplina, nome, codDisciplina, media, professor, nota_aprovação, situacao
		try {
			//continuar
			update.setString(1, disciplina.getNome());
			update.setString(2, disciplina.getCodDisciplina());
			update.setDouble(3, disciplina.getMedia());
			update.setString(4, disciplina.getProfessor());
			update.setDouble(5, disciplina.getNota_aprovacao());
			update.setBoolean(6, disciplina.isSituacao());
			update.setInt(7, disciplina.getId());
			update.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();

		}
	}
	
	public void updateMedias(int id) {
		try {
			//Avaliações da disciplina X
			List<Avaliacao> avs = avaliacaoDAO.selectAll(id);
			Double media = 0.0;
			Double nota_apro = 0.0;
			Boolean situ = false;
			for(Avaliacao av : avs ) {
				media += av.getNota() * av.getPeso();
 			}
			if(media < 7.0) {
				nota_apro = (-1.5 * media) + 12.5;
			}else {
				situ = true;
			}
			updateMedias.setDouble(1, media);
			updateMedias.setDouble(2, nota_apro);
			updateMedias.setBoolean(3, situ);
			updateMedias.setInt(4, id);
			updateMedias.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Disciplina select(int id) {
		try {
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				int id_d = rs.getInt(1);
				int id_s = rs.getInt(2);
				String nome = rs.getString(3);
				String prof = rs.getString(4);
				Double media = rs.getDouble(5);
				Double nota_apro = rs.getDouble(6);
				String cod = rs.getString(7);
				Boolean situ = rs.getBoolean(8);
				List<Avaliacao> avs = avaliacaoDAO.selectAll(id);
				return new Disciplina(id_s, id_d, nome, cod, prof, media, nota_apro, situ, avs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Disciplina> selectAll(int id_semestre){
		//retorna todos as disciplinas de um semestre
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		try {
			selectAll.setInt(1, id_semestre);
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int id_d = rs.getInt(1);
				int id_s = rs.getInt(2);
				String nome = rs.getString(3);
				//System.out.println(nome);
				String prof = rs.getString(4);
				Double media = rs.getDouble(5);
				Double nota_apro = rs.getDouble(6);
				String cod = rs.getString(7);
				Boolean situ = rs.getBoolean(8);
				List<Avaliacao> avs = avaliacaoDAO.selectAll(id_d);
				Disciplina aux = new Disciplina(id_s, id_d, nome, cod, prof, media, nota_apro, situ, avs);
				//System.out.println(aux.toString());
				disciplinas.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return disciplinas;
	}
}
