package dados;

import java.util.ArrayList;
import java.util.List;

public class Semestre {
	private String identificacao;
	public List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	//Métodos Previstos na Modelagem
	//		-> cadastrarDisciplina OK
	//		-> excluirDisciplina OK
	//		-> editarDisciplina OK
	
	@Override
	public boolean equals (Object obj) {
		if(obj instanceof Semestre) {
			Semestre aux = (Semestre)obj;
			if(this.identificacao.equals(aux.getIdentificacao())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}

	}
	
	public void editarDisciplina(Disciplina disciplina_edit) {
			for(Disciplina item : disciplinas) {
				if(disciplina_edit.getCodDisciplina() == item.getCodDisciplina()) {
					//Sobrescrever Método equal posteriormente
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
	
	public List<Disciplina> getDisciplinas(){
		return disciplinas;
	}
	
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	
	public String toString() {
		return "Identificador: "+identificacao;
	}
	
	public void mostraDisciplinas() {
		for(Disciplina item : disciplinas) {
			System.out.println("| "+item.toString()+" |");
		}
	}
}
