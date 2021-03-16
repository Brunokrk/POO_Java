package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import excecoes.*;
import dados.Disciplina;
import dados.Semestre;

public class SemestreDAO {
	private static SemestreDAO instance = null;
	private static DisciplinaDAO disciplinaDAO = null;
	private static AvaliacaoDAO avaliacaoDAO = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement deleteAll;
	private PreparedStatement select;
	private PreparedStatement selectAll; 
	private PreparedStatement update;
	
	public static SemestreDAO getInstance() {
		if(instance == null) {
			instance =  new SemestreDAO();
		}
		return instance;
	}
	
	private SemestreDAO( ) {
		Connection conexao = Conexao.getConexao();
		try {
			selectNewId = conexao.prepareStatement("select nextval('id_semestre')");
			insert = conexao.prepareStatement("insert into semestre values (?, ?)");
			delete = conexao.prepareStatement("delete from semestre where id = ?");
			deleteAll = conexao.prepareStatement("delete from semestre");
			select = conexao.prepareStatement("select * from semestre where id= ?");
			selectAll = conexao.prepareStatement("select * from semestre");
			update = conexao.prepareStatement("update semestre set identificacao = ? where id = ?");
			disciplinaDAO = DisciplinaDAO.getInstance();
			avaliacaoDAO = AvaliacaoDAO.getInstance();
		}catch( SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int selectNewId()  {
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
	
	public void insert(Semestre semestre) {
		semestre.setId(selectNewId());
		System.out.println(""+semestre.getIdentificacao()+" "+semestre.getId());
		try {
			insert.setInt(1,semestre.getId());
			insert.setString(2, semestre.getIdentificacao());
			insert.executeUpdate();
			//System.out.println("Inseriu semestre");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Semestre semestre) {
					
		//pegou todas as disciplinas do semestre
		List<Disciplina> aux_d = disciplinaDAO.selectAll(semestre.getId());
		for(Disciplina item : aux_d) {
			//deletou todos as avaliações de cada disciplina presente no semestre
			avaliacaoDAO.deleteAll(item.getId());
		}
		//deletou todas as disciplinas do semestre
		disciplinaDAO.deleteAll(semestre.getId());
			
		try {
			delete.setInt(1, semestre.getId());
			delete.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteAll() {
		try {
			deleteAll.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Semestre select(int id) {
		try {
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				int id_s = rs.getInt(1);
				String identi = rs.getString(2);
				return new Semestre(id_s, identi);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Semestre> selectAll(){
		List<Semestre> semestres = new ArrayList<Semestre>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int id_s = rs.getInt(1);
				String identi = rs.getString(2);
				List<Disciplina> disciplinas = disciplinaDAO.selectAll(id_s);	
				semestres.add(new Semestre(id_s, identi, disciplinas));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return semestres;
	}
	
	public void update(Semestre semestre) {
		try {
			update.setString(1,  semestre.getIdentificacao());
			update.setInt(2, semestre.getId());
			update.executeUpdate();
		}catch(SQLException e) {
		e.printStackTrace();
			
		}
	}
}
