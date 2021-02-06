package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.Semestre;
import dados.Disciplina;
import dados.Avaliacao;


public class Sistema {
	private List<Semestre> semestres = new ArrayList<Semestre>();
	
	//Métodos previstos na modelagem
	//cadastrarSemestre OK
	//excluirSemestre OK
	//editarSemestre ??
	//cadastrarDisciplina OK
	//excluirDisciplina OK
	//editarDisciplina OK
	//cadastrarAvaliacao OK
	//excluirAvaliacao OK
	//editarAvaliacao
	
	public void cadastrarSemestre(Semestre semestre) {
		this.semestres.add(semestre);
	}
	
	public void excluirSemestre(String identificação) {
		int i =0;
		for(Semestre item : semestres) {
			if(item.getIdentificacao()==identificação) {
				semestres.remove(i);
			}
			i++;
		}
	}
	
	public void cadastrarDisciplina(Semestre semestre, Disciplina disciplina) {
		for(Semestre item : semestres) {
			if(item.equals(semestre)) {
				item.cadastrarDisciplina(disciplina);
			}
		}
	}
	
	public void excluirDisciplina(Semestre semestre, String nome) {
		for(Semestre item : semestres) {
			if (item.getIdentificacao() == semestre.getIdentificacao()) {
				item.excluirDisciplina(nome);
			}
		}
	}
	
	public void editarDisciplina(Semestre semestre, Disciplina disciplina) {
		//Na apresentação, criar um método que identifica a disciplina informando o Código
		//E criar um método que busca as novas informações
		for(Semestre item : semestres) {
			if (item.getIdentificacao() == semestre.getIdentificacao()) {
				item.editarDisciplina(disciplina);
			}
		}
	}
	
	public void cadastrarAvaliacao(Semestre semestre, Disciplina disciplina, Avaliacao avaliacao) {
		for(Semestre item : semestres) {
			if (item.equals(semestre)) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.equals(disciplina)) {
						second_item.cadastrarAvaliacao(avaliacao);
					}
				}
			}
		}
	}
	
	public void excluirAvaliacao (Semestre semestre, Disciplina disciplina, Avaliacao avaliacao) {
		for(Semestre item : semestres) {
			if (item.getIdentificacao() == semestre.getIdentificacao()) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.getCodDisciplina() == disciplina.getCodDisciplina()) {
						for(Avaliacao third_item : second_item.avaliacoes) {
							if(third_item.equals(avaliacao)) {
								second_item.excluirAvaliacao(avaliacao.getNome());
							}
						}
					}
				}
			}
		}
	}
	
	public void editarAvaliacao (Semestre semestre, Disciplina disciplina, Avaliacao avaliacao, int id_edit) {
		for(Semestre item : semestres) {
			if (item.getIdentificacao() == semestre.getIdentificacao()) {
				for(Disciplina second_item : item.disciplinas) {
					if(second_item.getCodDisciplina() == disciplina.getCodDisciplina()) {
						for(Avaliacao third_item : second_item.avaliacoes) {
							if(third_item.equals(avaliacao)) {
								second_item.editarAvaliacao(avaliacao, id_edit);
							}
						}
					}
				}
			}
		}
	}
	
	public List<Semestre> getSemestres(){
		return semestres;
	}
	
	public void mostraSemestres() {
		System.out.println("**********SEMESTRES CADASTRADOS**********");
		for(Semestre item : semestres) {
			System.out.println("        | "+item.toString()+" | ");
		}
	}
	
	public void mostraDisciplinas(Semestre b) {
		System.out.println("**********DISCIPLINAS CADASTRADAS**********");
		
		for(Semestre item : semestres) {
			if(item.equals(b)) {			
				item.mostraDisciplinas();
			}
		}
	}
	
	public boolean verificaPossibilidade(Semestre a) {
		for(Semestre item : semestres) {
			if(item.equals(a)) {
				return false;
			}
		}
		return true;
	}
}
