package pratica6;

public class Fatorial extends Gerador {
	public void gerar(int n) {
		int fat =1;
		for(int i=2;i<=n;i++) {
			fat*=i;
			sequencia.add(fat);
		}
	}
}
