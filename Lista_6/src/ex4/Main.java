package ex4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PratoBuffet p1 = new PratoBuffet();
		p1.setPeso(1.0);
		p1.setTipoCliente(TipoCliente.ESTUDANTE);
		p1.setTipoDia(TipoDia.SEGUNDA);
		System.out.println(p1.calculaTotal());
		
		
		PratoBuffet p2 = new PratoBuffet();
		p2.setPeso(1.0);
		p2.setTipoCliente(TipoCliente.FUNCIONARIO);
		p2.setTipoDia(TipoDia.SEGUNDA);
		System.out.println(p2.calculaTotal());
		
	}

}
