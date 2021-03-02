package ex3;

public class SaldoInsuficienteException extends Exception {
	private Double valorFaltante;
	
	public SaldoInsuficienteException(double valor){
		super();
		this.valorFaltante = valor;
	}
	
	@Override
	public String toString() {
		return "Faltam "+valorFaltante;
	}
}
