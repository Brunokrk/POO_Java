package mongoPersistence;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.currentDate;
import static com.mongodb.client.model.Updates.set;

import dados.Empregado;
import dados.Estadia;
import persistencia.Conexao;

public class EstadiaMongoDAO {

	private static EstadiaMongoDAO instance = null;
	private static MongoCollection<Document> collection;
	
	
	public static EstadiaMongoDAO getInstance() {
		if(instance == null) 
			instance = new EstadiaMongoDAO();
		
		return instance;
	}
	
	private EstadiaMongoDAO() {
		MongoDatabase conn = ConexaoMongo.getConexao();
		try {
			collection = conn.getCollection("estadia");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert (Estadia estadia) {
		
		try {
			Document document = new Document("codestadia", estadia.getCodestadia())
					.append("checkin", estadia.getCheckin())
					.append("checkout", estadia.getCheckout())
					.append("valorextra", estadia.getValorextra())
					.append("codcliente", estadia.getCodcliente())
					.append("nroa", estadia.getNroa());
			collection.insertOne(document);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Estadia> selectAll(){
		ArrayList<Estadia> estadias = new ArrayList<Estadia>();
		
		try {
			MongoIterable<Document> newEst = collection.find();
			for(Document est : newEst) {
				Estadia estadia = new Estadia();
				
				estadia.setCodestadiaMongo(est.getObjectId("_id"));
				estadia.setCodestadia(est.getInteger("codestadia"));
				estadia.setCheckin(est.getString("checkin"));
				estadia.setCheckout(est.getString("checkout"));
				estadia.setValorextra(est.getDouble("valorextra"));
				estadia.setCodcliente(est.getInteger("codcliente"));
				estadia.setNroa(est.getInteger("nroa"));
				estadias.add(estadia);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return estadias;
	}
	
	public void atualizaEstadia(int cod, Double valor) {
		try {
			
			MongoIterable<Document> newEst = collection.find();
			for(Document est: newEst) {
				if(est.getInteger("codestadia") == cod) {
					Estadia estadia = new Estadia();
					
					estadia.setCodestadiaMongo(est.getObjectId("_id"));
					estadia.setCodestadia(est.getInteger("codestadia"));
					estadia.setCheckin(est.getString("checkin"));
					estadia.setCheckout(est.getString("checkout"));
					estadia.setValorextra(valor);
					estadia.setCodcliente(est.getInteger("codcliente"));
					estadia.setNroa(est.getInteger("nroa"));
					
					collection.updateOne(
			                eq("_id", estadia.getCodestadiaMongo()),
			                combine(set("valorextra", estadia.getValorextra()),currentDate("lastModified")));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
