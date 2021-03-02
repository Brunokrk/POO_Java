package ex2;

public class Quadrado extends FormaGeometrica {
	
	public double calcularArea() {
		return super.getMedida()*super.getMedida();
	}
	
	public double calcularPerimetro() {
		return 4* super.getMedida();
	}
}
