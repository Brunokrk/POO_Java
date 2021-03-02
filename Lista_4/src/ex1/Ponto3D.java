package ex1;

public class Ponto3D extends Ponto2D{
	private double x;
	private double y;
	private double z;
	
	
	public Ponto3D (double x, double y, double z) {
		super(x, y);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double calcularDistancia(Ponto3D outro) {
		double d = 0;
		d = Math.sqrt( Math.pow(outro.getX() - this.x, 2) + Math.pow(outro.getY() - this.y, 2)+ Math.pow(outro.getZ() - this.z, 2));
		return d;
	}
	
	
	
	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
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
