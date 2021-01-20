package dados;
import java.util.List;
import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private String professor;
	private Float media;
	private Float nota_aprovacao;
	private boolean situacao = false;//False até que seja aprovado
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	
	//Métodos Previstos na Modelagem
	//		-> cadastrarAvaliacao
	//		-> excluirAvaliacao
	//		-> editarAvaliacao
	//		-> calculoMedia
	//		-> notaNecessária
	
	
	
	public void cadastrarAvaliacao(Avaliacao avaliacao) {
		this.avaliacoes.add(avaliacao);
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
	
	public void editarAvaliacao(Avaliacao avaliacao_edit, int id_edit) {
		//nome id = 1
		//nota id = 2
		//peso id = 3
		//data id = 4
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
	public Float getNota_aprovacao() {
		return nota_aprovacao;
	}
	public void setNota_aprovacao(Float nota_aprovacao) {
		this.nota_aprovacao = nota_aprovacao;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	
}
