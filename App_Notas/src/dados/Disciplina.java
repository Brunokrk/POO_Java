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
	public List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	
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
	
	public void editarAvaliacao(Avaliacao avaliacao_edit) {
		for(Avaliacao item : avaliacoes) {
			if(item.equals(avaliacao_edit)) {
				item.setData(avaliacao_edit.getData());
				item.setNota(avaliacao_edit.getNota());
				item.setPeso(avaliacao_edit.getPeso());
			}
		}
	}
	
	@Override
	public boolean equals (Object obj) {
		if(obj instanceof Disciplina) {
			Disciplina aux = (Disciplina) obj;
			if(this.codDisciplina.equals(aux.codDisciplina)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	
	public List<Avaliacao> getAvaliacoes(){
		return avaliacoes;
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
	
	public String toString() {
		return "Disciplina: " +this.nome+" Código: "+this.codDisciplina+" Professor: "+this.professor;
	}
	
	public void mostraAvaliações() {
		for(Avaliacao item : avaliacoes) {
			System.out.println("| "+item.toString()+" |");
		}
	}
}
