package ex2;

public class Libra extends Moeda {
	public Libra(String simb, Double value) {
		super();
		this.simbolo = simb;
		this.valor = value;
	}
	@Override
	public Double converterDolar() {
		return this.valor * 1.38;
	}
}
