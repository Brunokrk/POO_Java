package dados;

public class Viveiro {
	protected String nome;
	protected float comprimento;
	protected float largura;
	protected Animal[] animais = new Animal[20];
	protected int numeroAnimais = 0;
	
	public float calculaEspaco() {
		return comprimento*largura;
	}
	
	public float espacoDisponivel() {
		float espaco = this.calculaEspaco();
		for(int i =0; i<20; i++) {
			espaco -= animais[i].calculaEspacoOcupado();
		}
		return espaco;
	}
	
	private float espacoOcupado() {
		float espaco = 0;
		for(int i =0; i<20; i++) {
			espaco += animais[i].calculaEspacoOcupado();		
		}
		return espaco;
	}
	
	public boolean adicionarAnimal(Animal animal) {
		if(this.espacoDisponivel() > animal.calculaEspacoOcupado() * 0.7) {
			animais[numeroAnimais] = animal;
			this.numeroAnimais ++;
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "	Nome: "+this.nome+"\n 	Comprimento: "+this.comprimento+"\n 	Largura: "+this.largura+"\n		Número Animais: "+this.numeroAnimais;
	}
	
	//getters and setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getComprimento() {
		return comprimento;
	}
	
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	
	public float getLargura() {
		return largura;
	}
	
	public void setLargura(float largura) {
		this.largura = largura;
	}
	
}
