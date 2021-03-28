package ex1;

/*Não Consegui achar o erro que gera o Loop, que por acaso foi o mesmo erro
 * que tive quando implementei o código do slide da aula :(
 * espero considerar algo da tentativa*/

public class Main {

	public static void main(String[] args) {
		Lista<Integer> lista = new Lista<Integer>(8);
		
		for(int k=0; k<8; k++) {
			lista.set(k, k);
		}
		
		while(lista.getIteratorLista().hasNext()) {
			System.out.println(lista.getIteratorLista().next());
		}
		
	}
	
}
