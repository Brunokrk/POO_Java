package ex3;

public abstract class OperacaoInteira {
	protected int a;
	protected int b;
	
	
	public abstract int calcula();
	
	public void setB(int b) {
		this.b = b;
	}
	public void setA(int a) {
		this.a = a;
	}
	
}
