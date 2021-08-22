package dados;

import org.bson.types.ObjectId;

public class Cliente {
	private ObjectId nRegistroMongo;
	private int nRegistro;
	private String cidade;
	private String estado;
	private String rua;
	private String bairro;
	private int telefone;
	private String nome;
	
	public Cliente() {
		
	}
	
	public Cliente(int nRegistro, String cidade, String estado, String rua, String bairro, int telefone, String nome) {
		super();
		this.nRegistro = nRegistro;
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.bairro = bairro;
		this.telefone = telefone;
		this.nome = nome;
	}

	public Cliente(ObjectId nRegistroMongo, String cidade, String estado, String rua, String bairro, int telefone, String nome) {
		super();
		this.nRegistroMongo = nRegistroMongo;
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.bairro = bairro;
		this.telefone = telefone;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return  nRegistro + ": " + nome + ", tel: " +telefone;
	}
	
	
}
