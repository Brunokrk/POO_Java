package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dados.Avaliacao;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;
import excecoes.UpdateException;


public class AvaliacaoDAO {
	private static AvaliacaoDAO instance = null;
	private PreparedStatement selectNewId;
	private PreparedStatement select;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement deleteAll;//deleta todas as avaliações de uma Disciplina X
	private PreparedStatement selectAll;//Seleciona todas as avaliacões de uma Disciplina X
	
	public static AvaliacaoDAO getInstance(){
		if(instance == null) {
			instance = new AvaliacaoDAO();
		}
		return instance;
	}
	
	private AvaliacaoDAO(){
		//Construtor
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('id_avaliacao')");
			insert = conexao.prepareStatement("insert into avaliacao values (?,?,?,?,?,?)");
			select = conexao.prepareStatement("select * from avaliacao where id = ?");
			update = conexao.prepareStatement("update avaliacao set idDisciplina = ?, nome = ?, nota = ?, peso = ?, dia = ? where id= ? ");
			delete = conexao.prepareStatement("delete from avaliacao where id = ?");
			deleteAll = conexao.prepareStatement("delete from avaliacao where idDisciplina = ?");
			selectAll = conexao.prepareStatement("select * from avaliacao where idDisciplina = ?");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int selectNewId() {
		try {
			ResultSet rs = selectNewId.executeQuery();
			if (rs.next()){
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void insert(Avaliacao av){
		try {
			insert.setInt(1, selectNewId());
			insert.setInt(2, av.getIdDisciplina());
			insert.setString(3, av.getNome());
			insert.setDouble(4, av.getNota());//mudar nota para float no banco de dados
			insert.setDouble(5, av.getPeso());
			insert.setString(6, av.getData());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();

		}
	}
	
	public Avaliacao select(int id){
		try {
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				int id_Av = rs.getInt(1);
				int id_Dis = rs.getInt(2);
				String nome = rs.getString(3);
				Double nota = rs.getDouble(4);
				Double peso = rs.getDouble(5);
				String data = rs.getString(6);
				return new Avaliacao(id_Dis, id_Av, nome, nota, peso, data);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(Avaliacao avaliacao){
		try {
			update.setInt(1, avaliacao.getIdDisciplina());
			update.setString(2,  avaliacao.getNome());
			update.setDouble(3, avaliacao.getNota());
			update.setDouble(4, avaliacao.getPeso());
			update.setString(5, avaliacao.getData());
			update.setInt(6, avaliacao.getId());
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
	
	public void deleteAll(int id_disciplina){
		try {
			deleteAll.setInt(1, id_disciplina);
			deleteAll.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Avaliacao> selectAll(int id_disciplina){
		//retorna todas as avaliações de uma disciplina X;
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		try {
			selectAll.setInt(1, id_disciplina);
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int id_a = rs.getInt(1);
				int id_d = rs.getInt(2);
				String nome = rs.getString(3);
				Double nota = rs.getDouble(4);
				Double peso = rs.getDouble(5);
				String dia = rs.getString(6);
				avaliacoes.add(new Avaliacao(id_d, id_a, nome, nota, peso, dia));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return avaliacoes;
	}
}








