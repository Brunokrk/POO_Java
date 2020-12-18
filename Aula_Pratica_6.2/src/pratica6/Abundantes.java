package pratica6;

public class Abundantes extends Gerador {
	public void gerar(int n) {
		int soma=0;
		for(int i=2; i<n; i++) {
			for(int j=1; j<i; j++) {
				if(i%j==0) {
					sequencia.add(i);
				}
			}
		}
	}
}
