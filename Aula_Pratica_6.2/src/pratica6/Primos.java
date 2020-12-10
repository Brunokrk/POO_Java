package pratica6;

public class Primos extends Gerador {
	public void gerar(int n) {
		int quant = 0;
		int num = 2;
		do {
			if(primo(num)) {
				sequencia.add(num);
				quant++;
			}
			num++;
		}while(quant <n);
	}
	
	public boolean primo(int n) {
		for (int i=2; i<n; i++) {
			if(n%i ==0) {
				return false;
			}
		}
		return true;
	}
}
