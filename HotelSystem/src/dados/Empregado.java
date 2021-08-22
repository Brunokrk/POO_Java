package dados;

import org.bson.types.ObjectId;

public class Empregado {
	private ObjectId nRegistroMongo;
	private int nRegistro;
	private String nome;
	
	public Empregado() {
		
	}
	public Empregado(int nRegistro, String nome) {
		this.nRegistro = nRegistro;
		this.nome = nome;
	}
	
	
	
	public ObjectId getnRegistroMongo() {
		return nRegistroMongo;
	}
	public void setnRegistroMongo(ObjectId nRegistroMongo) {
		this.nRegistroMongo = nRegistroMongo;
	}
	public int getnRegistro() {
		return nRegistro;
	}
	public void setnRegistro(int nRegistro) {
		this.nRegistro = nRegistro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return nRegistro + ": " + nome;
	}
	  
}
