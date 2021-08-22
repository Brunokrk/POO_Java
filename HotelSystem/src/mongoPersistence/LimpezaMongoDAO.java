package mongoPersistence;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dados.Limpeza;

public class LimpezaMongoDAO {
	private static LimpezaMongoDAO instance = null;
	private static MongoCollection<Document> collection;
	
	
	public static LimpezaMongoDAO getInstance() {
		if(instance == null)
			instance = new LimpezaMongoDAO();
		return instance;
	}
	
	private LimpezaMongoDAO() {
		MongoDatabase conn = ConexaoMongo.getConexao();
		try {
			collection = conn.getCollection("limpeza");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Limpeza limpeza) {
		try {
			Document document = new Document("codlimpeza", limpeza.getCodLimpeza())
					.append("tempo", limpeza.getTempo())
					.append("nregemp", limpeza.getnRegEmp())
					.append("codestadia", limpeza.getcodEstadia());
			
			collection.insertOne(document);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
