package ex5;

import java.util.Random;

public class SacoDeMoedas {
	private Moeda[] moedas = new Moeda[10];
	private Random gerador = new Random();
	private int num_moedas = 0;
	private int valorRetirado = 0;
	private int valorTotal = 0;
	
	public void adicionaMoeda(Moeda moeda) {
		this.moedas[num_moedas] = moeda;
		this.num_moedas++;
		this.valorTotal += moeda.getValor();
	}
	

	public Moeda[] puxarMoedas(int x) {
		Moeda[] aux = new Moeda[x];
		int indice = 0;
		
		if(x < 10) {
			for (int i=0; i<x; i++) {
				indice = this.fazSorteio();
				aux[i] = moedas[indice];
				this.valorRetirado += moedas[indice].getValor();
				this.moedas[indice].setValor(-1);
			}
		}
		this.valorTotal -= this.valorRetirado;
		return aux;
	}
	
	public int fazSorteio() {
		int indiceSorteado = 0;
		
		indiceSorteado = gerador.nextInt(10);
		
		if(moedas[indiceSorteado].getValor() != -1) {
			return indiceSorteado;
		}else {
			return this.fazSorteio();
		}
	}
	
	public int getValorRetirado() {
		return valorRetirado;
	}
	
	public int getValorTotal() {
		return valorTotal;
	}
}
