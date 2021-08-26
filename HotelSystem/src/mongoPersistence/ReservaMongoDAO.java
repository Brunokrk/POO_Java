package mongoPersistence;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import dados.Cliente;
import dados.Reserva;

public class ReservaMongoDAO {
	private static ReservaMongoDAO instance = null;
	private static MongoCollection<Document> collection;
	
	
	public static ReservaMongoDAO getInstance() {
		if(instance == null)
			instance = new ReservaMongoDAO();
		return instance;
	}
	
	private ReservaMongoDAO() {
		MongoDatabase conn = ConexaoMongo.getConexao();
		try {
			collection = conn.getCollection("reserva");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Reserva reserva) {
		try {
			Document document = new Document("codreserva", reserva.getCodreserva())
					.append("nroa", reserva.getNroa())
					.append("codestadia", reserva.getCodestadia())
					.append("diaentrada", reserva.getDiaentrada())
					.append("diareserva", reserva.getDiareserva())
					.append("codcliente", reserva.getCodcliente());
			collection.insertOne(document);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Reserva> selectAll(){
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		try {
			MongoIterable<Document> newRes = collection.find();
			for(Document res : newRes) {
				Reserva reserva = new Reserva();
				reserva.setIdmongo(res.getObjectId("_id"));
				reserva.setCodcliente(res.getInteger("codcliente"));
				reserva.setCodestadia(res.getInteger("codestadia"));
				reserva.setCodreserva(res.getInteger("codreserva"));
				reserva.setDiaentrada(res.getString("diaentrada"));
				reserva.setDiareserva(res.getString("diareserva"));
				reservas.add(reserva);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	
}
