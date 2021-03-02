package ex2;

public class Circulo extends FormaGeometrica{
	
	public double calcularArea() {
		return Math.PI * super.getMedida()*super.getMedida();
	}
	
	public double calcularPerimetro() {
		return 4* Math.PI * super.getMedida();
	}
	
}
