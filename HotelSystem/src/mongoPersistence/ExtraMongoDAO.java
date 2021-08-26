package mongoPersistence;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import dados.Cliente;
import dados.Extra;

public class ExtraMongoDAO {
	private static ExtraMongoDAO instance = null;
	private static TipoServicoMongoDAO tipoMongo;
	private static EstadiaMongoDAO estadiaMongo;
	private static MongoCollection<Document> collection;
	
	
	public static ExtraMongoDAO getInstance() {
		if(instance == null)
			instance = new ExtraMongoDAO();
		return instance;
	}
	
	private ExtraMongoDAO() {
		MongoDatabase conn = ConexaoMongo.getConexao();
		try {
			collection = conn.getCollection("extra");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Extra extra) {
		try {
			Document document = new Document("codextra", extra.getCodExtra())
					.append("codtipo", extra.getCodTipo())
					.append("ccodestadia", extra.getCodEstadia())
					.append("dia", extra.getDia())
					.append("hora", extra.getHora());
			
			collection.insertOne(document);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void calculaExtra(int cod) {
		Double money = 0.0;
	
		try {
			MongoIterable<Document> newExt = collection.find();
			for(Document ext: newExt) {
				if(ext.getInteger("ccodestadia") == cod) {
					money += tipoMongo.getInstance().retornaPreco(ext.getInteger("codtipo"));
				}
			}
			
			//System.out.println(money);
			estadiaMongo.getInstance().atualizaEstadia(cod, money);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
