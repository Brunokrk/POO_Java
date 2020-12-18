package pratica6;

public class Fibonacci extends Gerador {
	public void gerar(int n) {
		int atual =0;
		int anterior = 0;
		for(int i=0; i<n; i++) {
			if(i==1) {
				atual = 1;
				anterior = 0;
			}else{
				atual += anterior;
				anterior = atual - anterior;
			}
			sequencia.add(atual);
		}
	}
}
