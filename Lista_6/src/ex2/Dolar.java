package ex2;

public class Dolar extends Moeda {
	
	public Dolar(String simb, Double value) {
		super();
		this.simbolo = simb;
		this.valor = value;
	}
	
	
	public Double converteDolar() {
		return this.valor;
	}
}
