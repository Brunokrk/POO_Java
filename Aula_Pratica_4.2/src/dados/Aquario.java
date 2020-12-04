package dados;

public class Aquario extends Viveiro{
	
	public Aquario() {
		super();
	}

	private float altura;
	private float temperatura;
	
	@Override
	public float calculaEspaco() {
		return this.altura *super.comprimento *super.largura;
	}
	

	
	//getters and setters
	public float getAltura() {
		return altura;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public float getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	
	public String toString() {
		return super.toString() +"\n     Altura: "+this.altura+"\n     Temperatura"+this.temperatura;
	}
	
}

