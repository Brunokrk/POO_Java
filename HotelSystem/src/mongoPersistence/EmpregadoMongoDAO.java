package mongoPersistence;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import dados.Empregado;

public class EmpregadoMongoDAO {
	private static EmpregadoMongoDAO instance = null;
	private static MongoCollection<Document> collection;
	
	
	public static EmpregadoMongoDAO getInstance() {
		if(instance == null)
			instance = new EmpregadoMongoDAO();
		return instance;
	}
	
	private EmpregadoMongoDAO() {
		MongoDatabase conn = ConexaoMongo.getConexao();
		try {
		collection = conn.getCollection("empregado");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Empregado> selectAll(){
		ArrayList<Empregado> empregados = new ArrayList<Empregado>();
		try {
			MongoIterable<Document> newEmp = collection.find();
			for(Document emp : newEmp) {
				Empregado empregado = new Empregado();
				empregado.setnRegistroMongo(emp.getObjectId("_id"));
				empregado.setNome(emp.getString("nome"));
				empregado.setnRegistro(emp.getInteger("nRegistro"));
				empregados.add(empregado);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return empregados;
	}
	
	
}
