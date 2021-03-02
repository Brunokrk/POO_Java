package ex3;

import java.util.Date;

public class Boleto {
	private Double valor;
	private Date vencimento;
	
	public Boleto(Double valor, Date data) {
		this.valor = valor;
		this.vencimento = data;
	}
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	
	
}
