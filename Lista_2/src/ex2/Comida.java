package ex2;

public class Comida {
	private String nome;
	private String kcal;
	private String macro_proteinas;
	private String macro_carboidratos;
	private String macro_gorduras;
	
	public Comida(String nome, String kcal, String macro_proteinas, String macro_carboidratos, String macro_gorduras){
		this.nome = nome;
		this.kcal = kcal;
		this.macro_proteinas = macro_proteinas;
		this.macro_carboidratos = macro_carboidratos;
		this.macro_gorduras = macro_gorduras;
	}
	public Comida(String nome, String kcal){
		this.nome = nome;
		this.kcal = kcal;
	}
	
	public String toString() {
		return "Nome: "+this.nome+"\n kcal: "+this.kcal+"\n Quantidade Proteínas: "+this.macro_proteinas + "\n Quantidae Carboidratos: "+this.macro_carboidratos+"\n Quantidade de Gorduras"+ this.macro_gorduras;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Comida) {
			Comida aux = (Comida) obj;
			if(this.nome.equals(aux.getNome()) && this.kcal.equals(aux.getKcal()) && this.macro_proteinas.equals(aux.getMacro_proteinas()) && this.macro_carboidratos.equals(aux.getMacro_carboidratos()) && this.macro_gorduras.equals(aux.macro_gorduras)){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getKcal() {
		return kcal;
	}
	public void setKcal(String kcal) {
		this.kcal = kcal;
	}
	public String getMacro_proteinas() {
		return macro_proteinas;
	}
	public void setMacro_proteinas(String macro_proteinas) {
		this.macro_proteinas = macro_proteinas;
	}
	public String getMacro_carboidratos() {
		return macro_carboidratos;
	}
	public void setMacro_carboidratos(String macro_carboidratos) {
		this.macro_carboidratos = macro_carboidratos;
	}
	public String getMacro_gorduras() {
		return macro_gorduras;
	}
	public void setMacro_gorduras(String macro_gorduras) {
		this.macro_gorduras = macro_gorduras;
	}
	
	
}
