package dados;

import java.util.ArrayList;
import java.util.List;

public class Semestre {
	private String identificacao;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	
	
}
