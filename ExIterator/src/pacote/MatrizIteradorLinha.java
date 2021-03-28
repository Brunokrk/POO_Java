package pacote;

public class MatrizIteradorLinha<T> implements Iterator<T> {
	private Matriz<T> matriz;
	private int atualI = 0;
	private int atualJ = 0;
	
	private int i;
	private int j;
	
	public MatrizIteradorLinha(Matriz<T> matriz) {
		this.matriz = matriz;
	}
	
	@Override
	public void reset() {
		atualI = 0;
		atualJ = 0;
	}
	
	@Override
	public boolean hasNext() {
		return atualI < matriz.getM() && atualJ < matriz.getN();
	}
	
	@Override 
	public T next() {
		i = atualI;
		j = atualJ;
		if(atualJ == matriz.getN() - 1) {
			//precisamos pular uma linha
			atualJ = 0;
			atualI ++;
		}else {
			atualJ++;
		}
		if(atualI == matriz.getM() && atualJ == matriz.getN()) {
			reset();
		}
		return matriz.get(i, j);
	}
}
