package dados;

public class Semestre {
	private int id;
	private String identificacao;
	
	public Semestre(int id, String identi) {
		this.id = id;
		this.identificacao = identi;
	}
	
	public Semestre() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	
	
}
