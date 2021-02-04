package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.Semestre;
import dados.Disciplina;


public class Sistema {
	private List<Semestre> semestres = new ArrayList<Semestre>();
	
	//M�todos previstos na modelagem
	//cadastrarSemestre OK
	//excluirSemestre OK
	//editarSemestre ??
	//cadastrarDisciplina 
	//excluirDisciplina
	//editarDisciplina
	//cadastrarAvaliacao
	//excluirAvaliacao
	//editarAvaliacao
	
	private void cadastrarSemestre(Semestre semestre) {
		this.semestres.add(semestre);
	}
	
	private void excluirSemestre(String identifica��o) {
		int i =0;
		for(Semestre item : semestres) {
			if(item.getIdentificacao()==identifica��o) {
				semestres.remove(i);
			}
			i++;
		}
	}
	
	private void cadastrarDisciplina(Semestre semestre, Disciplina disciplina) {
		for(Semestre item : semestres) {
			if(item.getIdentificacao()== semestre.getIdentificacao()) {
				item.cadastrarDisciplina(disciplina);
			}
		}
	}
	
	
	
}
