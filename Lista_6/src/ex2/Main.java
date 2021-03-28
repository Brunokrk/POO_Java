package ex2;

public class Main {

	private static MoedaFactory moedaFactory;
	
	public static void main(String[] args) {
		
		Moeda r1 = moedaFactory.getInstance().createMoeda(EnumerateMoedas.REAL, "R$", 1.00);
		Moeda l1 = moedaFactory.getInstance().createMoeda(EnumerateMoedas.LIBRA, "US$", 1.00);
		Moeda d1 = moedaFactory.getInstance().createMoeda(EnumerateMoedas.DOLAR, "£", 1.00);
		Moeda e1 = moedaFactory.getInstance().createMoeda(EnumerateMoedas.EURO, "€", 1.00);
		Moeda g1 = moedaFactory.getInstance().createMoeda(EnumerateMoedas.GUARANI, "g", 10.00);
		
		System.out.println(r1.converterDolar());
		System.out.println(l1.converterDolar());
		System.out.println(d1.converterDolar());
		System.out.println(e1.converterDolar());
		System.out.println(g1.converterDolar());
		
	}

}
