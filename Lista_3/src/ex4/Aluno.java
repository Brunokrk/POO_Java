package ex4;

public class Aluno implements Comparable<Aluno>{
	private String nome;
	private int idade;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString() {
		return "\tNome: "+this.nome+"\tIdade: "+this.idade;
	}
	
	@Override
	public int compareTo(Aluno outroAluno) {
		if(this.idade<outroAluno.getIdade()) {
			return -1;
		}else if(this.idade > outroAluno.getIdade()) {
			return 1;
		}
		return 0;
	}
	
}
