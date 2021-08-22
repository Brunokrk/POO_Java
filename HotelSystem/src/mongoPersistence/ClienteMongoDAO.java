package mongoPersistence;



import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import dados.Cliente;

public class ClienteMongoDAO {
	private static ClienteMongoDAO instance = null;
	private static MongoCollection<Document> collection;
	
	
	public static ClienteMongoDAO getInstance() {
		if(instance == null)
			instance = new ClienteMongoDAO();
		return instance;
	}
	
	private ClienteMongoDAO() {
		MongoDatabase conn = ConexaoMongo.getConexao();
		try {
			collection = conn.getCollection("cliente");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Cliente cliente) {
		try {
			Document document = new Document("nRegistro", cliente.getnRegistro())
					.append("nome", cliente.getNome())
					.append("cidade", cliente.getCidade())
					.append("estado", cliente.getEstado())
					.append("rua", cliente.getRua())
					.append("bairro", cliente.getBairro())
					.append("telefone", cliente.getTelefone());
			collection.insertOne(document);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cliente> selectAll(){
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			MongoIterable<Document> newCli = collection.find();
			for(Document cli : newCli) {
				Cliente cliente = new Cliente();
				cliente.setnRegistroMongo(cli.getObjectId("_id"));
				cliente.setnRegistro(cli.getInteger("nRegistro"));
				cliente.setNome(cli.getString("nome"));				 
				cliente.setCidade(cli.getString("cidade"));
				cliente.setEstado(cli.getString("estado"));
				cliente.setRua(cli.getString("rua"));
				cliente.setBairro(cli.getString("bairro"));
				cliente.setTelefone(cli.getInteger("telefone"));
				clientes.add(cliente);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return clientes;
		
	}
	
}









