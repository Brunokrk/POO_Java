public class Pessoa {
	
	//Atributos
	private String nome;
	private int idade;
	private float altura;
	private float massa;
	
	//Construtor -> por padrão, java ja cria um construtor vazio
	public Pessoa() {
		
	}
	
	//Métodos
	//Definição dos gets e sets
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getIdade() {
		return idade;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getAltura() {
		return altura;
	}
	
	public void setMassa(float massa) {
		this.massa = massa;
	}
	public float getMassa() {
		return massa;
	}
	
	public float calculcaImc() {
		return (this.massa / (this.altura *this.altura));
	}
	
	
}
