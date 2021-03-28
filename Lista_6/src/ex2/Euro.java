package ex2;

public class Euro extends Moeda {
	public Euro(String simb, Double value) {
		super();
		this.simbolo = simb;
		this.valor = value;
	}
	@Override
	public Double converterDolar() {
		return this.valor * 1.18;
	}
}
