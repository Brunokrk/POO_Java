package ex2;

public class MoedaFactory {
	
	private static MoedaFactory instance = null;
	
	private MoedaFactory() {
		
	}
	
	public static MoedaFactory getInstance() {
		if(instance == null) {
			instance = new MoedaFactory();
		}
		return instance;
	}
	
	public Moeda createMoeda(EnumerateMoedas tipo, String simb, Double value) {
		switch(tipo) {
			case REAL:
				return new Real(simb, value);
			case DOLAR:
				return new Dolar(simb, value);
			case LIBRA:
				return new Libra(simb, value);
			case GUARANI:
				return new Guarani(simb, value);
			case EURO:
				return new Euro(simb, value);
			default:
				throw new IllegalArgumentException("Tipo de moeda inválido");
		}
	}
	
}
