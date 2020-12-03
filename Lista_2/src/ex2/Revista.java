package ex2;

public class Revista {
	private String nome;
	private String editora;
	private String mes_publicacao;
	private String preco;
	
	public Revista(String nome, String editora, String mes_publicacao, String preco) {
		this.nome = nome;
		this.editora = editora;
		this.mes_publicacao = mes_publicacao;
		this.preco = preco;
	}
	
	public Revista(String nome, String mes_publicacao, String preco) {
		this.nome = nome;
		this.editora = "Elsevier";
		this.mes_publicacao = mes_publicacao;
		this.preco = preco;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Revista) {
			Revista aux = (Revista) obj;
			if(this.nome.equals(aux.getNome()) && this.editora.equals(aux.getEditora()) && this.mes_publicacao.equals(aux.getMes_publicacao()) && this.preco.equals(aux.getPreco())){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Nome: "+this.nome+"\n Editora: "+this.editora+"\n Publicacao: "+this.mes_publicacao + "\n Preço: "+this.preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getMes_publicacao() {
		return mes_publicacao;
	}
	public void setMes_publicacao(String mes_publicacao) {
		this.mes_publicacao = mes_publicacao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
}
