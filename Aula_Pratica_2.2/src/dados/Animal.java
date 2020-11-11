package dados;

public class Animal {
	private String nome;
	public Dono d=  new Dono();
	private String especie;
	private String descricao;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setDono(Dono d) {
		this.d = d;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getEspecie() {
		return this.especie;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return this.descricao;
	}

}
