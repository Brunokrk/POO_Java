package ex5;

import java.util.Scanner;

public class Principal {

		private static Scanner leitor = new Scanner(System.in);
		private static SacoDeMoedas saco = new SacoDeMoedas();
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			adicionaMoeda(i);
		}
		
		System.out.println("Informe o numero de moedas (<10) que deseja tirar do saco");
		int n = Integer.parseInt(leitor.nextLine());
		saco.puxarMoedas(n);
		
		System.out.println("Valor Retirado: "+ saco.getValorRetirado());
	}
	
	private static void adicionaMoeda(int i) {
		Moeda aux = new Moeda();
		System.out.println("Infome o valor da moeda "+ i);
		aux.setValor(Integer.parseInt(leitor.nextLine()));
		saco.adicionaMoeda(aux);
	}
	
}
