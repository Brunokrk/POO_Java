package teste;

public class main {
	public static void main(String[]args) {
		ObjetoA objeto = new ObjetoA();
		Teste teste = new Teste();
		
		teste.setElemento1(objeto);
		System.out.println(teste.getElemento1().toString());
		teste.setElemento1(12);
		System.out.println(teste.getElemento1().toString());
	}
}
