package ex3;
import java.util.Date;

public class BoletoVencidoException extends Exception {
	private Date dataVencimento;
	
	public BoletoVencidoException(Date dataVencimento) {
		super();
		this.dataVencimento = dataVencimento;
	}
	
	@Override
	public String toString() {
		return "Boleto está vencido: "+ dataVencimento.toString();
	}
	
	
}
