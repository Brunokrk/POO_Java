package ex1;

public class Pessoa {
	private String nome;
	private int idade;
	private String cpf;
	private String cidade;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String toString() {
		return "\tNome:"+this.nome+"\tIdade:"+this.idade+"\tCPF:"+this.cpf+"\tCidade:"+this.cidade;
	}
	
}
