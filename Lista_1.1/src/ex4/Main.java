package ex4;

public class Main {
	public static void main(String[] args) {
		int v[] = {1,3,5,6,7,9,10};
		
		int resultado = somaRecursiva(v, 0);
		
		System.out.println("Considerando 1 como número primo");
		System.out.println("Somatório é: "+resultado);
	}
	
	private static int somaRecursiva(int[] v, int i) {
		if(i<v.length) {
			if(ehPrimo(v[i])) {
				return v[i] +somaRecursiva(v, i+1);
			}
			else {
				return somaRecursiva(v, i+1);
			}
		}else {
			return 0;
		}
	}
	
	private static boolean ehPrimo(int numero) {
	    for (int j = 2; j < numero; j++) {
	        if (numero % j == 0)
	            return false;   
	    }
	    return true;
	}
}
