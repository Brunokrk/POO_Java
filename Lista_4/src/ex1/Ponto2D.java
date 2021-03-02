package ex1;

public class Ponto2D {
	private double x;
	private double y;
	
	public Ponto2D (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double calcularDistancia(Ponto2D outro) {
		double d = 0;
		d = Math.sqrt( Math.pow(outro.getX() - this.x, 2) + Math.pow(outro.getY() - this.y, 2));
		return d;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
}
