package ex2;

public class Carro {
	private String cor;
	private String modelo;
	private String marca;
	
	
	public Carro(String cor, String modelo, String marca) {
		this.cor = cor;
		this.modelo = modelo;
		this.marca = marca;
	}
	
	public Carro(String modelo, String marca) {
		this.cor = "Prateado";
		this.modelo = modelo;
		this.marca = marca;
	}
	
	public String toString() {
		return " Marca: "+this.marca+"\n Modelo: "+this.modelo+"\n Cor: "+this.cor;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Carro) {
			Carro aux = (Carro) obj;
			if(this.cor.equals(aux.getCor()) && this.modelo.equals(aux.getModelo()) && this.marca.equals(aux.getMarca())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
