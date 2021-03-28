package ex3;

import java.util.LinkedList;
import java.util.List;

public class Veiculo implements Sujeito {
	private List<Observador> observadores = new LinkedList<Observador>();
	
	private String placa;
	private Double velocidade;
	
	public Veiculo(String placa) {
		this.placa = placa;
		this.velocidade = 0.0;
	}
	
	public void acelerar() {
		this.velocidade = this.velocidade + 5.00;
	}
	
	public void adicionar(Observador observador) {
		observadores.add(observador);
	}
	
	public void remover(Observador observador) {
		observadores.remove(observador);
	}
	
	public void notificar() {
		for(Observador ob : observadores) {
			ob.atualizar(this.velocidade);
		}
	}
}
