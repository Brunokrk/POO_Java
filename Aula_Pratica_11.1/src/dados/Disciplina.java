package dados;
import java.util.List;
import java.util.ArrayList;

public class Disciplina {
	private int id;
	private int idSemestre;
	private String nome;
	private String professor;
	private Double media = 0.0;
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
	
	public Disciplina() {
		
	}
	
	public Disciplina(int id_s, int id_d, String nome, String cod, String professor, Double media, Double nota_apro, Boolean situ, List<Avaliacao> lista ) {
		
	}
	
	public void cadastrarAvaliacao(Avaliacao avaliacao) {
		avaliacao.setIdDisciplina(this.id);
		this.avaliacoes.add(avaliacao);
		calculoMedia();
	}
	

	public void excluirAvaliacao(String nome) {
		
		for(int i =0; i<avaliacoes.size(); i++) {
			Avaliacao av = avaliacoes.get(i);
			if(av.getNome().equals(nome)) {
				avaliacoes.remove(av);
				break;
			}
		}
		
	}
	
	public void notaNecessaria() {
		this.nota_aprovacao = (-1.5 * this.media) + 12.5;
	}
	
	public void calculoMedia() {
		for(Avaliacao item : avaliacoes) {
			this.media += item.getNota()* item.getPeso();
		}
		if(this.media >= 7.0) {
			setSituacao(true);
		}
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
	
	public void mostraAvaliações() {
		for(Avaliacao item : avaliacoes) {
			System.out.println("| "+item.toString()+" |");
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
	
	
	
	public int getIdSemestre() {
		return idSemestre;
	}


	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}


	public void setNota_aprovacao(Double nota_aprovacao) {
		this.nota_aprovacao = nota_aprovacao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
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
	
	public String getCodDisciplina() {
		return codDisciplina;
	}
	
	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	
	public String toString() {
		return "Disciplina: " +this.nome+" Código: "+this.codDisciplina+" Professor: "+this.professor;
	}
	
}
