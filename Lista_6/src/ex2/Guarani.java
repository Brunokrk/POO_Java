package ex2;

public class Guarani extends Moeda {
	public Guarani(String simb, Double value) {
		super();
		this.simbolo = simb;
		this.valor = value;
	}
	@Override
	public Double converterDolar() {
		return this.valor * 0.00015;
	}
	
}
