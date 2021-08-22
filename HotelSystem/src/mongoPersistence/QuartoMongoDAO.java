package mongoPersistence;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import dados.Cliente;
import dados.QuartoMongo;

public class QuartoMongoDAO {
	private static QuartoMongoDAO instance = null;
	private static MongoCollection<Document> collection;
	
	
	public static QuartoMongoDAO getInstance() {
		if(instance == null)
			instance = new QuartoMongoDAO();
		return instance;
	}
	
	private QuartoMongoDAO() {
		MongoDatabase conn = ConexaoMongo.getConexao();
		try {
			collection = conn.getCollection("quarto");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<QuartoMongo> selectAll(){
		
		ArrayList<QuartoMongo> quartos = new ArrayList<QuartoMongo>();
		
		try {
			MongoIterable<Document> newQua = collection.find();
			for(Document qua : newQua) {
				QuartoMongo quarto = new QuartoMongo();
				quarto.setIdMongo(qua.getObjectId("_id"));
				quarto.setCodHotel(qua.getInteger("codhotel"));
				//System.out.print(quarto.getCodHotel());
				quarto.setNroa(qua.getInteger("nroa"));
				quarto.setAndar(qua.getInteger("andar"));
				quarto.setTipo(qua.getString("tipo"));
				quarto.setPreco(qua.getDouble("preco"));
				quartos.add(quarto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return quartos;
		
	}
	
	
}
