package dados;
import java.util.List;
import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private String professor;
	private Float media;
	private Double nota_aprovacao;
	private String codDisciplina;
	private boolean situacao = false;//False até que seja aprovado
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	
	//Métodos Previstos na Modelagem
	//		-> cadastrarAvaliacao OK
	//		-> excluirAvaliacao OK
	//		-> editarAvaliacao OK
	//		-> calculoMedia OK
	//		-> notaNecessária OK
	
	
	public void cadastrarAvaliacao(Avaliacao avaliacao) {
		this.avaliacoes.add(avaliacao);
	}
	
	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public void excluirAvaliacao(String nome) {
		int i=0;
		for(Avaliacao item : avaliacoes) {
			if (item.getNome().equals(nome)) {
				avaliacoes.remove(i);
			}
			i++;
		}
	}
	
	public void notaNecessaria() {
		this.nota_aprovacao = (-1.5 * this.media) + 12.5;
	}
	
	public void calculoMedia() {
		for(Avaliacao item : avaliacoes) {
			this.media += item.getNota();
		}
		this.media = this.media / avaliacoes.size();
	}
	
	public void editarAvaliacao(Avaliacao avaliacao_edit, int id_edit) {
		//nome id = 1
		//nota id = 2
		//peso id = 3
		//data id = 4
		
		//botar um identificador não editavel
		if (id_edit != 1) {
			for(Avaliacao item : avaliacoes) {
				if (item.getNome().equals(avaliacao_edit.getNome())) {
					item.setNota(avaliacao_edit.getNota());
					item.setPeso(avaliacao_edit.getPeso());
					item.setData(avaliacao_edit.getData());
				}
			}
		}else if(id_edit == 1) {
			for(Avaliacao aux : avaliacoes) {
				if(aux.getData().equals(avaliacao_edit.getData())) {
					aux.setNome(avaliacao_edit.getNome());
				}
			}
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public Float getMedia() {
		return media;
	}
	public void setMedia(Float media) {
		this.media = media;
	}
	public Double getNota_aprovacao() {
		return nota_aprovacao;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	
}
