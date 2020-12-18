package pratica6;

public class Perfeitos extends Gerador {
	public void gerar(int n) {
		int soma=0;
		boolean flag = true;
		int i=1;
		int cont =0;
		while(flag) {
			for(int j=1; j<i; j++) {
				if(i%j == 0) {
					soma+=j;
				}
			}
			if(soma == i) {
				sequencia.add(i);
				cont++;
			}
			if(cont==n) {
				flag = true;
			}
			i++;
			soma =0;
		}
	}
}
