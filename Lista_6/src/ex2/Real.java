package ex2;

public class Real extends Moeda {
	public Real(String simb, Double value) {
		super();
		this.simbolo = simb;
		this.valor = value;
	}
	
	@Override
	public Double converterDolar() {
		return this.valor * 5.76;
	}
}
