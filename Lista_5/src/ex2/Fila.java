package ex2;

import java.util.List;
import java.util.ArrayList;

public class Fila<T> {
	private int max;
	private List<T> fila = new ArrayList<T>();
	
	private Fila(int tam) {
		this.max = tam;
	}
	
	private void add(T objeto) throws FilaCheiaException{
		if(tamanho() == max)
			throw new FilaCheiaException();
	}
	
	private int tamanho() {
		return fila.size();
	}
	
}
