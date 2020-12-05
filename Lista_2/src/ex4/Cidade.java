package ex4;

public class Cidade {
	private String nome;
	private int habitantes;
	private float renda;
	
	public float rendaPerCapta() {
		return this.renda / this.habitantes;
	}
	
	public String toString() {
		return"     Nome: "+this.nome+"\n     Habitantes: "+this.habitantes+"\n     Renda: "+this.renda;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	public float getRenda() {
		return renda;
	}
	public void setRenda(float renda) {
		this.renda = renda;
	}
	
	
}
