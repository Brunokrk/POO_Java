package ex2;

public class Pais {
	private String nome;
	private String area;
	private String populacao;
	private String continente;
	
	public Pais(String nome, String area, String populacao, String continente){
		this.nome = nome;
		this.area = area;
		this.populacao = populacao;
		this.continente = continente;
	}
	
	public Pais(String nome, String area, String populacao){
		this.nome = nome;
		this.area = area;
		this.populacao = populacao;
		this.continente = "America";
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Pais) {
			Pais aux = (Pais) obj;
			if(this.nome.equals(aux.getNome()) && this.area.equals(aux.getArea()) && this.populacao.equals(aux.getPopulacao()) && this.continente.equals(aux.getContinente())){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Nome: "+this.nome+"\n Continente: "+this.continente+"\n Área: "+this.area + "\n População: "+this.populacao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPopulacao() {
		return populacao;
	}
	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	
	
}
