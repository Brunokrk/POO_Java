package dados;

public class Endereco {
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private int cep;
	
	public Endereco() {
	
	}
	//Gets e Sets
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getRua() {
		return this.rua;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return this.numero;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getBairro() {
		return this.bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCidade() {
		return this.cidade;
	}
	
	public void setCep(int cep) {
		this.cep = cep;
	}
	public int getCep() {
		return this.cep;
	}
	
}
