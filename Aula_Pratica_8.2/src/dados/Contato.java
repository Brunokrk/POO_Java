package dados;

public class Contato {
	private String nome;
	private int telefone;
	
	//public Contato(String nome, int telefone) {
	//	this.nome = nome;
	//	this.telefone = telefone;
	//}
	
	public String toString() {
		return "	"+this.nome+": "+this.telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Contato) {
			Contato aux = (Contato) obj;
			if(this.nome.equals(aux.getNome()) && this.telefone==aux.telefone){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
