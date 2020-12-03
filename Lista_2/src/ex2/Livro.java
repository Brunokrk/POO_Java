package ex2;

public class Livro {
	private String autor;
	private String titulo;
	private String editora;
	
	public Livro(String autor, String titulo, String editora) {
		this.autor = autor;
		this.titulo = titulo;
		this.editora = editora;
	}
	
	public Livro(String autor, String titulo) {
		this.autor = autor;
		this.titulo = titulo;
		this.editora = "Elsevier";
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Livro) {
			Livro aux = (Livro) obj;
			if(this.autor.equals(aux.getAutor()) && this.titulo.equals(aux.getTitulo()) && this.editora.equals(aux.getEditora())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Título: "+this.titulo+"\n Autor: "+this.autor+"\n Editora: "+this.editora;
	}
	
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutor() {
		return this.autor;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public String getEditora() {
		return this.editora;
	}
}
