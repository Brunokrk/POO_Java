package ex4;

public class Par<T> {
	private T elemento1 = null;
	private T elemento2 = null;
	
	public String toString() {
		return this.elemento1.toString()+" && "+ this.elemento2.toString();
	}
	
	public T getElemento1() {
		return elemento1;
	}
	public void setElemento1(T elemento1) {
		this.elemento1 = elemento1;
	}
	public T getElemento2() {
		return elemento2;
	}
	public void setElemento2(T elemento2) {
		this.elemento2 = elemento2;
	}
}
