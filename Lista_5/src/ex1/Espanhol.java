package ex1;

public class Espanhol implements Idioma {

	@Override
	public String boasVindas() {
		return "Bienvenido!";
	}
	
	@Override
	public String finalizar() {
		return "Saliendo...";
	}
	
	@Override
	public String requisitarValor() {
		return "Ingresse un n´umero inteiro";
	}
	
	@Override
	public String somarValores(int x, int y) {
		return "X más Y es " + (x+y);
	}
	
	@Override
	public String multiplicarValores(int x, int y) {
		return "X por Y es "+ (x*y);
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

	    return "El mínimo común múltiplo entre X e Y es "+ ((x * y) / a);
	}
}
