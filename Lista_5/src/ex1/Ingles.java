package ex1;

public class Ingles implements Idioma {

	@Override
	public String boasVindas() {
		return "Welcome!";
	}
	
	@Override
	public String finalizar() {
		return "Exiting...";
	}
	
	@Override
	public String requisitarValor() {
		return "Type an integer:";
	}
	
	@Override
	public String somarValores(int x, int y) {
		return "X plus Y is " + (x+y);
	}
	
	@Override
	public String multiplicarValores(int x, int y) {
		return "X times Y is "+ (x*y);
	}
	
	@Override
	public String mmcValores(int x, int y) {
		int resto;
	    int a = x;
	    int b = y;
	    while (b != 0) {
	       resto = a % b;
	       a = b;
	       b = resto;
	    }

	    return "The least common multiple between X and Y is "+ ((x * y) / a);
	}
	
}
