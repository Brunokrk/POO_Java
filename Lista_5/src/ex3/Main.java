package ex3;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date data1 = new Date(2022, 10, 10, 18, 40, 30);
		Date data2 = new Date(2020, 10, 10, 18, 40, 30);
		ContaBancaria conta = new ContaBancaria(1000.0);
		
		
		Boleto boleto1 = new Boleto(1300.0, data1);
		conta.pagarBoleto(boleto1);
		conta.sacar(900.0);
		
		Boleto boleto2 = new Boleto(50.0, data1);
		conta.pagarBoleto(boleto2);
	}

}
