package pacote;

public class Matriz<T> {
	private T[][] matriz;
	private int m;
	private int n;
	
	private Iterator<T> iteradorLinha = new MatrizIteradorLinha<T>(this);
	//private Iterator<T> iteradorColuna = new MatrizIteratorColuna<T>(this);
	
	public Matriz(int m, int n) {
		this.m = m;
		this.n = n;
		this.matriz = (T[][])(new Object[m][n]);
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}
	
	public void set(int i, int j, T elemento) {
		matriz [i][j] = elemento;
	}
	
	public T get(int i, int j) {
		return matriz[i][j];
	}
	
	public Iterator<T> getIteradorLinha(){
		this.iteradorLinha.reset();
		return this.iteradorLinha;
	}
	
	
}
