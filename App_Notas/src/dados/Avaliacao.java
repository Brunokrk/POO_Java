package dados;

public class Avaliacao {
	private int id;
	private String nome; //id = 1
	private Float nota;	//id = 2
	private Float peso; //id = 3
	private String data; //id = 4
	private int IdDisciplina;
	
	@Override
	public boolean equals (Object obj) {
		if(obj instanceof Avaliacao) {
			Avaliacao aux = (Avaliacao) obj;
			if(this.nome.equals(aux.getNome())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public Avaliacao(int id_Dis, int id_Av, String nome, Float nota, Float peso, String data){
		this.IdDisciplina = id_Dis;
		this.id = id_Av;
		this.nome = nome;
		this.nota = nota;
		this.peso = peso;
		this.data = data;
	}
	
	public Avaliacao(){
		
	}
	
	
	public int getIdDisciplina() {
		return IdDisciplina;
	}


	public void setIdDisciplina(int idDisciplina) {
		IdDisciplina = idDisciplina;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getNota() {
		return nota;
	}
	public void setNota(Float nota) {
		this.nota = nota;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return this.data + " " +this.nome+" Nota:" +this.nota +" Peso:"+this.peso;
	}
}
