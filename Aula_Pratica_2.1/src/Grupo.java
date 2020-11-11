
public class Grupo {
	private Pessoa[] pessoas;
	private int quantPessoas = 0;
	
	public Grupo (int tam) {
		pessoas = new Pessoa[tam];
	}
	
	public void setPessoa(Pessoa p) {
		if(quantPessoas < pessoas.length) {
			pessoas[quantPessoas] = p;	
			quantPessoas++;
		}
	}
	
	public void ordena() {
		for(int i=0; i<pessoas.length; i++) {
			for(int j = i +1; j<pessoas.length; j++) {
				if(pessoas[j].calculcaImc() > pessoas[i].calculcaImc()) {
					Pessoa aux = pessoas[i];
					pessoas[j] = pessoas[i];
					pessoas[i]=aux;
				}
			}
		}
	}
	
	
}
