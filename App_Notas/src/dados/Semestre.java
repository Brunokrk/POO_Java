package dados;

import java.util.ArrayList;
import java.util.List;

public class Semestre {
	private String identificacao;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	//M�todos Previstos na Modelagem
	//		-> cadastrarDisciplina OK
	//		-> excluirDisciplina OK
	//		-> editarDisciplina OK

	public void editarDisciplina(Disciplina disciplina_edit, int id_edit) {
		//nome id = 1
		//professor id = 2
			for(Disciplina item : disciplinas) {
				if(disciplina_edit.getCodDisciplina() == item.getCodDisciplina()) {
					//Sobrescrever M�todo equal posteriormente
					item.setNome(disciplina_edit.getNome());
					item.setProfessor(disciplina_edit.getProfessor());
				}
			}
		
	}
	
	public void cadastrarDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public void excluirDisciplina(String nome) {
		int i = 0;
		for(Disciplina item : disciplinas) {
			if(item.getNome().equals(nome)) {
				disciplinas.remove(i);
			}
			i++;
		}
	}
	
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	
	
}
