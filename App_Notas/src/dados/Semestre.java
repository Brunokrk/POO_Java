package dados;

import java.util.ArrayList;
import java.util.List;

public class Semestre {
	private int id;
	private String identificacao;
	public List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	//M�todos Previstos na Modelagem
	//		-> cadastrarDisciplina OK
	//		-> excluirDisciplina OK
	//		-> editarDisciplina OK
	
	public Semestre(int id, String identi) {
		this.id = id;
		this.identificacao = identi;
	}
	
	public Semestre(int id, String identi, List<Disciplina> disciplinas) {
		this.id = id;
		this.identificacao = identi;
		this.disciplinas = disciplinas;
	}
	
	public Semestre() {
		
	}
	
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
	
	public void editarDisciplina(Disciplina disciplinaA, Disciplina disciplina_edit) {
			for(Disciplina item : disciplinas) {
				if(disciplinaA.equals(item)) {
					item = disciplina_edit;
				}
			}
	}
	
	public void cadastrarDisciplina(Disciplina disciplina) {
		disciplina.setIdSemestre(this.id);
		this.disciplinas.add(disciplina);
	}
	
	public void excluirDisciplina(String cod) {
		
		for(int i=0; i<disciplinas.size(); i++) {
			Disciplina d = disciplinas.get(i);
			
			if(d.getCodDisciplina().equals(cod)) {
				disciplinas.remove(d);
				break;
			}
		}
		
	}
	
	public List<Disciplina> getDisciplinas(){
		return disciplinas;
	}
	public Disciplina getDisciplina(String cod) {
		for(Disciplina item : disciplinas) {
			if(item.getCodDisciplina().equals(cod)) {
				return item;
			}
		}
		return null;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
			//item.mostraAvalia��es();
		}
	}
	
	public boolean verificaPossibilidadeAddDisciplina(Disciplina d) {
		for (Disciplina item : disciplinas) {
			if(item.equals(d)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean verificaPossibilidadeExclDisciplina(String cod) {
		for (Disciplina item : disciplinas) {
			if(item.getCodDisciplina().equals(cod)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
