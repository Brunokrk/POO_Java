package ex2;

public class Moeda {
	protected String simbolo;
	protected Double valor;
	
	
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double converterDolar() {
		return this.valor;
	}
	

}
