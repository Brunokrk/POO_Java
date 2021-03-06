package dados;

public class Avaliacao {
	private String nome; //id = 1
	private Float nota;	//id = 2
	private Float peso; //id = 3
	private String data; //id = 4
	
	@Override
	public boolean equals (Object obj) {
		if(obj instanceof Avaliacao) {
			Avaliacao aux = (Avaliacao) obj;
			if(this.nome.equals(aux.getNome())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getNota() {
		return nota;
	}
	public void setNota(Float nota) {
		this.nota = nota;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return this.data + " " +this.nome+" Nota:" +this.nota +" Peso:"+this.peso;
	}
}
