package dados;

public class Peixe extends Animal {
	public Peixe() {
		super();
	}
	
	private float temperaturaIdeal;

	@Override
	public float calculaEspacoOcupado() {
		//para peixes
		return super.comprimento * super.altura * super.largura;
	}
	
	//getters and setters
 	public float getTemperaturaIdeal() {
		return temperaturaIdeal;
	}

	public void setTemperaturaIdeal(float temperaturaIdeal) {
		this.temperaturaIdeal = temperaturaIdeal;
	}
	
}
