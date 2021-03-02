package ex3;

import java.util.Date;

public class ContaBancaria {
	private Double saldo;

	public ContaBancaria(Double valor) {
		this.saldo = valor;
	}
	
	public void sacar(Double valor) {
		try {
			if(valor > saldo) {
				throw new SaldoInsuficienteException(valor - saldo);
			}else {
				this.saldo = this.saldo - valor;
				System.out.println("Saque efetuado");
			}
			
		}catch(SaldoInsuficienteException si) {
			System.out.println(si.toString());
		}
	}
	
	public void pagarBoleto(Boleto boleto) {
		Date atual = new Date();
		try {
			if(boleto.getVencimento().compareTo(atual) == -1) {
				throw new BoletoVencidoException(boleto.getVencimento());
			}else if(boleto.getValor() > this.saldo) {
				throw new SaldoInsuficienteException(boleto.getValor()- saldo);
			}else {
				this.saldo = this.saldo - boleto.getValor();
			}
		}catch(BoletoVencidoException | SaldoInsuficienteException ee) {
			System.out.println(ee.toString());
		}
		
		
		
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
