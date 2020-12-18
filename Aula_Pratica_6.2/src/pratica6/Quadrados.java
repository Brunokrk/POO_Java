package pratica6;

public class Quadrados extends Gerador {
	public void gerar(int n) {
		for (int i =0; i<n; i++) {
			double aux = new Double(i);
			Double resultado = Math.sqrt(aux);
			if(resultado.intValue()==resultado.doubleValue()) {
				sequencia.add(i);
			}
		}
	}
}
