package dados;

public class Veterinario {
	private String nome;
	private int salario;
	private int qtdAnimais;
	public Endereco end = new Endereco();
	public Animal[] animais = new Animal[50];
	
	public void setAnimal(Animal a) {
		if(this.qtdAnimais < 50) {
			animais[this.qtdAnimais] = a;
			this.qtdAnimais++;
		}
	}
	public String getAnimal(int i) {
		String aux = animais[i].getNome();
		return aux;
	}
	public void setEndereco(Endereco e) {
		this.end = e;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	public void setSalario(int salario){
		this.salario = salario;
	}
	public int getSalario(){
		return this.salario;
	}
	public void setQtdAnimais(int qtdAnimais){
		this.qtdAnimais = qtdAnimais;
	}
	public int getQtdAnimais(){
		return this.qtdAnimais;
	}
	
	
}
