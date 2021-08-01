package dados;

public class Empregado {
	private int nRegistro;
	private String nome;
	
	public Empregado() {
		
	}
	public Empregado(int nRegistro, String nome) {
		this.nRegistro = nRegistro;
		this.nome = nome;
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
