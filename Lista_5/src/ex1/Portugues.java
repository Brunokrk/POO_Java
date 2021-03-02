package ex1;

public class Portugues implements Idioma {

	@Override
	public String boasVindas() {
		return "Bem-vindo!";
	}
	
	@Override
	public String finalizar() {
		return "Finalizando...";
	}
	
	@Override
	public String requisitarValor() {
		return "Digite um inteiro:";
	}
	
	@Override
	public String somarValores(int x, int y) {
		return "X mais Y �: " + (x+y);
	}
	
	@Override
	public String multiplicarValores(int x, int y) {
		return "X vezes Y �: "+ (x*y);
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

	    return "O m�nimo multiplo comum entre X e Y �: "+ ((x * y) / a);
	}
	
}
