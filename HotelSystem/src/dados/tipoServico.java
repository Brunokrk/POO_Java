package dados;

public class tipoServico {
	private int codTipo;
	private String tipo;
	private Double preco;
	
	public tipoServico(int codtipo, String tipo, Double preco) {
		this.codTipo = codTipo;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public tipoServico() {
		
	}
	
	public int getCodTipo() {
		return codTipo;
	}
	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
