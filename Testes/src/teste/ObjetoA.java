package teste;

public class ObjetoA {
	public String nome = "ABCDE";
	public int idade = 18; 
	
	public void edita(ObjetoA aux) {
		this.idade = aux.idade;
		this.nome = aux.nome;
	}
}
