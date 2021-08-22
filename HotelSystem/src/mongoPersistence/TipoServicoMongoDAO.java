package mongoPersistence;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import dados.Empregado;
import dados.tipoServico;

public class TipoServicoMongoDAO {
	private static TipoServicoMongoDAO instance = null;
	private static MongoCollection<Document> collection;
	
	
	public static TipoServicoMongoDAO getInstance() {
		if(instance == null)
			instance = new TipoServicoMongoDAO();
		return instance;
	}
	
	private TipoServicoMongoDAO() {
		MongoDatabase conn = ConexaoMongo.getConexao();
		try {
		collection = conn.getCollection("tiposervico");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<tipoServico> selectAll(){
		ArrayList<tipoServico> servicos = new ArrayList<tipoServico>();
		try {
			MongoIterable<Document> newSer = collection.find();
			for(Document ser : newSer) {
				tipoServico servico = new tipoServico();
				servico.setTipo(ser.getString("tipo"));
				servico.setPreco(ser.getDouble("preco"));
				servico.setCodTipo(ser.getInteger("codtipo"));
				servicos.add(servico);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return servicos;
	}
}
