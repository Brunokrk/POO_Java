package dados;

public class Dono {
	private String nome;
	private Endereco end = new Endereco();
	private String cpf;
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCpf() {
		return this.cpf;
	}
	
	public void setEndereco(Endereco e) {
		this.end = e;
	}
}
