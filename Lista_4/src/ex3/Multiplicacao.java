package ex3;

public class Multiplicacao extends Soma {
	
	public int calcular() {
		int result =  0;
		for(int i=1; i<=super.a; i++) {
			result += super.b;
		}
		return super.a*super.b;
	}
	
}
