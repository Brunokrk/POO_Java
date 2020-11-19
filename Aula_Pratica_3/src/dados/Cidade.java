package dados;

public class Cidade {
	private String nome;
	private String estado;
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado() {
		return this.estado;
	}
	
	public String toString() {
		return this.nome+", "+this.estado;
	}
}
